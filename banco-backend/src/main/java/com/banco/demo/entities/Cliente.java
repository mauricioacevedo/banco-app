package com.banco.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id @GeneratedValue
    private Integer id;

    @NotBlank @Size(max = 50)
    private String nombre;
    @NotBlank @Size(max = 100)
    private String direccion;
    @NotBlank @Size(max = 30)
    private String ciudad;
    @NotBlank @Size(max = 20)
    private String telefono;


    @OneToMany(mappedBy = "cliente",
            fetch = FetchType.EAGER)
    private List<Tarjeta> tarjetas;
}
