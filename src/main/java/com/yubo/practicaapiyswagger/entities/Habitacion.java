package com.yubo.practicaapiyswagger.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idhabitacion;

    @Column(name = "tamaño")
    private int tamano;

    @Column(name = "capacidad")
    private int capacidad;

    @Column(name = "precio_noche")
    private Double precioNoche;

    @Column(name = "incluye_desayuno")
    private Boolean incluyeDesayuno;

    @Column(name = "ocupada")
    private Boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "idhotel", referencedColumnName="idhotel")
    @JsonBackReference
    @ToString.Exclude
    private Hotel hotel;

}
