package com.yubo.practicaapiyswagger.service;

import com.yubo.practicaapiyswagger.entities.Hotel;
import com.yubo.practicaapiyswagger.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServices {
    private final HotelRepository hotelRepository;

    public HotelServices(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel saveHotel(Hotel hotel) { return hotelRepository.save(hotel); }

    public List<Hotel> findAllHotal() {

        return hotelRepository.findAll();
    }

    public List<Hotel> findHotelByLocal(String localidad) {
        return  hotelRepository.findByLocalidad(localidad);
    }

    public List<Hotel> findHotelByCategoria(int categoria) {
        return  hotelRepository.findByCategoria(categoria);




    }
}
