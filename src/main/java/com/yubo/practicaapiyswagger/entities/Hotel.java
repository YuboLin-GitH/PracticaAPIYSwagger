package com.yubo.practicaapiyswagger.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhotel")
    private int idhotel;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "categoria")
    private int categoria;
    @Column(name = "piscina")
    private Boolean piscina;
    @Column(name = "localidad")
    private String localidad;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference //OJO ahi que ponerlo para que no sea un bucle infinito
    // ERROR --> Infinite Recursion with Jackson JSON and Hibernate JPA
    @ToString.Exclude
    private List<Habitacion> habitacions ;


}
