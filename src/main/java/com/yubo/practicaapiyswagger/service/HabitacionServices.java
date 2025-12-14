package com.yubo.practicaapiyswagger.service;

import com.yubo.practicaapiyswagger.entities.Habitacion;
import com.yubo.practicaapiyswagger.entities.Hotel;
import com.yubo.practicaapiyswagger.repository.HabitacionRepository;
import com.yubo.practicaapiyswagger.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServices {
    private final HabitacionRepository habitacionRepository;

    public HabitacionServices(HabitacionRepository habitacionRepository) { this.habitacionRepository = habitacionRepository; }

    public Habitacion saveHabitacion(Habitacion habitacion) { return habitacionRepository.save(habitacion); }

    public List<Habitacion> findAllHabitacion() {

        return habitacionRepository.findAll();
    }

    public List<Habitacion> findAllHabitacionLibre(int idhotel, int tamanoMin, int tamanoMax, double precioMin, double precioMax) {

        return habitacionRepository.findAllHabitacionLibre(idhotel, tamanoMin, tamanoMax, precioMin, precioMax);
    }

}
