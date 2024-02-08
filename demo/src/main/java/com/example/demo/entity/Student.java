package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long studentID;
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NIA")
    private String nia;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String name;
    @Size(max = 50)
    @Column(name = "APELLIDOS")
    private String surname;
}
