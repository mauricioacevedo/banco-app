package com.banco.demo.services;

import com.banco.demo.entities.Asesor;
import com.banco.demo.repositories.AsesorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Component
public class AsesorService {

    private AsesorRepository asesorRepository;


    public List<Asesor> findAll() {
        return this.asesorRepository.findAll();
    }

    public Asesor save(Asesor c) {
        return this.asesorRepository.save(c);
    }

    public Optional<Asesor> findById(Integer id) {
        return this.asesorRepository.findById(id);
    }

    public void delete(Asesor asesor) {
        this.asesorRepository.delete(asesor);
    }
}
