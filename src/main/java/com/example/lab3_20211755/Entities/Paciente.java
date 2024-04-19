package com.example.lab3_20211755.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@Table(name = "paciente")
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "diagnostico", nullable = false)
    private String diagnostico;

    @Column(name = "fecha_cita", nullable = false)
    private String fechaCita;

    @Column(name = "numero_habitacion", nullable = false)
    private Integer numHabitacion;

    @Column(name = "oftalmologo_id", nullable = false)
    private Integer oftalmologoId;

    @Column(name = "clinica_id", nullable = false)
    private Integer clinicaId;

}
