package com.banco.demo.services;

import com.banco.demo.entities.Consumo;
import com.banco.demo.repositories.ConsumoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Component
public class ConsumoService {

    private ConsumoRepository consumoRepository;

    public List<Consumo> findAll() {
        return this.findAll();
    }

    public Consumo save(Consumo c) {
        return this.consumoRepository.save(c);
    }

    public Optional<Consumo> findById(Integer id) {
        return this.consumoRepository.findById(id);
    }

    public void delete(Consumo consumo) {
        this.consumoRepository.delete(consumo);
    }

    public List<Consumo> findConsumosByTarjeta(Integer tarjetaId) {
        return this.consumoRepository.findConsumosByTarjeta(tarjetaId);
    }
}
