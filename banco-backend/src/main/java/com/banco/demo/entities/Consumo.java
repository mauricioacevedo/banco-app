package com.banco.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "consumos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumo {

    @Id @GeneratedValue
    private Integer id;


    private Date fechaConsumo;
    private String descripcion;
    private Double monto;


    private Integer tarjetaId;
    private Integer cuotas;
}
