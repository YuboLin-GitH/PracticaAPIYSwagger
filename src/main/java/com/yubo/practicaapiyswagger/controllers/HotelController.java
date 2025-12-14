package com.yubo.practicaapiyswagger.controllers;

import com.yubo.practicaapiyswagger.entities.Hotel;
import com.yubo.practicaapiyswagger.service.HotelServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    private final HotelServices hotelServices;

    public HotelController(HotelServices hotelServices) {

        this.hotelServices = hotelServices;
    }

    @GetMapping("/")
    // http://localhost:9999/api/hotel/
    public List<Hotel> getAllHotels() {

        try {
            return hotelServices.findAllHotal();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todos los hoteles", e);
        }

    }


    @GetMapping("/localidad/{localidad}")
    // http://localhost:9999/api/hotel/localidad/Madrid
    public ResponseEntity<?> getLocalidad(@PathVariable String localidad) {
        try{
            List<Hotel> hotels = hotelServices.findHotelByLocal(localidad);

            if (hotels.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(hotels);
        } catch (Exception e){
            // SI FALLA
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Error buscar hotel por localidad: ", e);
        }
    }


    @GetMapping("/categoria/{categoria}")
    // http://localhost:9999/api/hotel/categoria/5
    public ResponseEntity<?> getCategoria(@PathVariable int categoria) {
        try{
            List<Hotel> hotels = hotelServices.findHotelByCategoria(categoria);

            if (hotels.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(hotels);
        } catch (Exception e){
            // SI FALLA
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Error buscar hotel por categoria: ", e);
        }
    }


    // c.     Registrar un nuevo hotel
    @PostMapping("save")
    /*
    POST   http://localhost:9999/api/hotel/save
    {
    "nombre": "Hotel Valencia Center",
    "descripcion": "Un hotel moderno cerca del arte",
    "categoria": 4,
    "piscina": true,
    "localidad": "Valencia"
    }


    */
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel) {
        try {
            // se vuelve datos que has creado
            Hotel hotelGuardado = hotelServices.saveHotel(hotel);
            //  CREADO (si se guardó correctamente)
            return new ResponseEntity<>(hotelGuardado, HttpStatus.CREATED);
        } catch (Exception e) {
            // SI HAY UN ERROR AL GUARDAR EL HOTEL, SE DEVUELVE UN MENSAJE DE ERROR
            return new ResponseEntity<>("Error al guardar el hotel: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
