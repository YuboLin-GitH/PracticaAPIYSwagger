package com.yubo.practicaapiyswagger.repository;

import com.yubo.practicaapiyswagger.entities.Habitacion;
import com.yubo.practicaapiyswagger.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    @Query("SELECT h FROM Habitacion h WHERE h.hotel.idhotel = :idhotel " +
    "AND h.tamano between :tamanoMin AND :tamanoMax " +
    "AND h.precioNoche between  :precioMin AND :precioMax " +
    "AND h.ocupada = false")
    List<Habitacion> findAllHabitacionLibre( @Param("idhotel") int idhotel,
                                             @Param("tamanoMin") int tamanoMin,
                                             @Param("tamanoMax") int tamanoMax,
                                             @Param("precioMin") double precioMin,
                                             @Param("precioMax") double precioMax);

}
