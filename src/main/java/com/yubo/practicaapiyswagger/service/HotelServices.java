package com.yubo.practicaapiyswagger.service;

import com.yubo.practicaapiyswagger.entities.Hotel;
import com.yubo.practicaapiyswagger.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

public class HotelServices {
    private final HotelRepository hotelRepository;

    public HotelServices(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel saveHotel(Hotel hotel) { return hotelRepository.save(hotel); }

    public List<Hotel> findAllHotal() {

        return hotelRepository.findAll();
    }


}
