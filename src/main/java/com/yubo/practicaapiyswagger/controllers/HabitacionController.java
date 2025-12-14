package com.yubo.practicaapiyswagger.controllers;

import com.yubo.practicaapiyswagger.entities.Habitacion;
import com.yubo.practicaapiyswagger.entities.Hotel;
import com.yubo.practicaapiyswagger.service.HabitacionServices;
import com.yubo.practicaapiyswagger.service.HotelServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * ClassName: HabitacionController
 * Package: com.yubo.practicaapiyswagger.controllers
 * Description:
 *
 * @Author linlin
 * @Create 14/12/2025 19:36
 * @Version 1.0
 */


@RestController
@RequestMapping("/api/habitacion")
public class HabitacionController {

    private final HabitacionServices habitacionServices;


    public HabitacionController(HabitacionServices habitacionServices) {
        this.habitacionServices = habitacionServices;
    }

    @GetMapping("/")
    // http://localhost:9999/api/habitacion/
    public List<Habitacion> getAllHabitacion() {
        try {
            return habitacionServices.findAllHabitacion();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todas las habitaciones", e);
        }

    }


    @GetMapping("/habitacioneslibres/{idhotel}/{tamanoMin}/{tamanoMax}/{precioMin}/{precioMax}")
    // http://localhost:9999/api/habitacion/habitacioneslibres/2/1/1000/1.00/500.00
    public List<Habitacion> getAllHabitacionLibres(
            @PathVariable int idhotel,
            @PathVariable int tamanoMin,
            @PathVariable int tamanoMax,
            @PathVariable double precioMin,
            @PathVariable double precioMax
    ) {
        try {
            return habitacionServices.findAllHabitacionLibre(idhotel, tamanoMin, tamanoMax, precioMin, precioMax);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todos los habitacion por este id", e);
        }

    }

    // d.     Registrar una nueva habitación a un hotel

    @PostMapping("save")
    /*
    POST   http://localhost:9999/api/habitacion/save
{
    "tamano": 30,
    "capacidad": 2,
    "precioNoche": 88.50,
    "incluyeDesayuno": true,
    "ocupada": false,
    "hotel": {
        "idhotel": 1
    }
}



    */
    public ResponseEntity<?> createHabitacion(@RequestBody Habitacion habitacion) {
        try {
            // comprueba si existir
            if (habitacion.getHotel() == null || habitacion.getHotel().getIdhotel() == 0) {
                return new ResponseEntity<>("Error: Debes especificar el id del hotel", HttpStatus.BAD_REQUEST);
            }
            habitacionServices.saveHabitacion(habitacion);
            //  CREADO (si se guardó correctamente)
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            // SI HAY UN ERROR AL GUARDAR EL HOTEL, SE DEVUELVE UN MENSAJE DE ERROR
            return new ResponseEntity<>("Error al guardar la habitacion: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // e. Eliminar una habitación determinada de un hotel

    @DeleteMapping("/delete/{idhabitacion}")
    // http://localhost:9999/api/habitacion/delete/1
    public ResponseEntity<?> deleteHabitacion(@PathVariable int idhabitacion) {
        try {
            habitacionServices.deleteHabitacionById(idhabitacion);

            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // f. Modificar una habitación para indicar que está ocupada

    /*
    @PutMapping("edit")
    // {
    //    "idhabitacion": 1,
    //    "ocupada": true,
    //    "tamano": 30,
    //    "hotel": { "idhotel": 2 }
    //}


    // forma normal
    public   ResponseEntity<?> updateHabitacion( @RequestBody Habitacion habitacion) {
        habitacionServices.updateHabitacion(habitacion);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    */

    // forma mejor para modificar
    @PutMapping("/ocupar/{idhabitacion}")
    //   http://localhost:9999/api/habitacion/ocupar/5
    public ResponseEntity<?> markAsOccupied(@PathVariable int idhabitacion) {
        try {
            habitacionServices.ocuparHabitacion(idhabitacion);
            return ResponseEntity.ok("Habitación marcada como ocupada.");
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



}
