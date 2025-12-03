package com.yubo.practicaapiyswagger.repository;

import com.yubo.practicaapiyswagger.entities.Habitacion;
import com.yubo.practicaapiyswagger.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
}
