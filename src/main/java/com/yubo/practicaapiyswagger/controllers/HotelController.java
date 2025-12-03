package com.yubo.practicaapiyswagger.controllers;

import com.yubo.practicaapiyswagger.entities.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {


    @GetMapping("/")
    public List<Hotel> getAllHotels() {

        try {
            return agricultorServices.findAllAgricultores();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todos los hoteles", e);
        }

    }


}
