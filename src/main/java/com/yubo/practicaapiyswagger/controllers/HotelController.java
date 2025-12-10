package com.yubo.practicaapiyswagger.controllers;

import com.yubo.practicaapiyswagger.entities.Hotel;
import com.yubo.practicaapiyswagger.service.HotelServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    public ResponseEntity<?> getLocalidad(@PathVariable String localidad) {

        return ResponseEntity.of(hotelServices.findHotelByLocal(localidad));
    }
    @GetMapping("/categoria/{categoria}")
    // http://localhost:9999/api/hotel/1
    public ResponseEntity<?> getCategoria(@PathVariable int categoria) {

        return ResponseEntity.of(hotelServices.findHotelByCategoria(categoria));
    }




}
