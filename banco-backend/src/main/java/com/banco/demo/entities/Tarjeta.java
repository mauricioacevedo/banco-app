package com.banco.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "tarjetas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarjeta {

    @Id @GeneratedValue
    private Integer id;

    @NotBlank
    private String numeroTarjeta;
    @NotBlank
    private String ccv;

    private String tipo;

    private Integer cliente;

    @NotBlank
    private String estadoTarjeta;
    private Date fechaCreacion;
    private Date fechaExpiracion;

    @OneToOne
    @JoinColumn(name = "asesor_bancario")
    private Asesor asesorBancario;
}
