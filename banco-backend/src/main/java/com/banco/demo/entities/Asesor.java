package com.banco.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asesor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asesor {

    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;

    private String especialidad;
}
