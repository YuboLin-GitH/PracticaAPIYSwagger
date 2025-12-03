package com.yubo.practicaapiyswagger.repository;

import com.yubo.practicaapiyswagger.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {


    @Query("SELECT h FROM Hotel h WHERE h.localidad = :localidad")
    List<Hotel> findHotelByLocal(String localidad);

}
