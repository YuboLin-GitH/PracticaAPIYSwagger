package com.yubo.practicaapiyswagger.controllers;

import com.yubo.practicaapiyswagger.entities.Hotel;
import com.yubo.practicaapiyswagger.service.HotelServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    private final HotelServices hotelServices;

    public HotelController(HotelServices hotelServices) {

        this.hotelServices = hotelServices;
    }

    @GetMapping("/")
    public List<Hotel> getAllHotels() {

        try {
            return HotelServices.();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al obtener todos los hoteles", e);
        }

    }


}
