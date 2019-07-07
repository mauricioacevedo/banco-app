package com.banco.demo.services;

import com.banco.demo.entities.Tarjeta;
import com.banco.demo.repositories.TarjetaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Component
public class TarjetaService {
    private TarjetaRepository tarjetaRepository;

    public List<Tarjeta> findAll() {
        return this.tarjetaRepository.findAll();
    }

    public Tarjeta save(Tarjeta c) {
        return this.save(c);
    }

    public Optional<Tarjeta> findById(Integer id) {
        return this.tarjetaRepository.findById(id);
    }

    public void delete(Tarjeta tarjeta) {
        this.tarjetaRepository.delete(tarjeta);
    }
}
