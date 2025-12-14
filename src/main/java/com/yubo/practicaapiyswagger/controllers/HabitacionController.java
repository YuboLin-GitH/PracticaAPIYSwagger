package com.yubo.practicaapiyswagger.controllers;

import com.yubo.practicaapiyswagger.entities.Habitacion;
import com.yubo.practicaapiyswagger.entities.Hotel;
import com.yubo.practicaapiyswagger.service.HabitacionServices;
import com.yubo.practicaapiyswagger.service.HotelServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
