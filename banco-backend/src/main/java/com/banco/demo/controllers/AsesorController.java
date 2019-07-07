package com.banco.demo.controllers;

import com.banco.demo.entities.Asesor;
import com.banco.demo.entities.Asesor;
import com.banco.demo.repositories.AsesorRepository;
import com.banco.demo.repositories.AsesorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
public class AsesorController {

    private final AsesorRepository asesorRepository;


    @GetMapping(path = "/asesores")
    public List<Asesor> getAllAsesores(){
        return this.asesorRepository.findAll();
    }

    @PostMapping(path = "/asesores")
    public Asesor createAsesor(@Valid @RequestBody Asesor c){

        return this.asesorRepository.save(c);
    }

    @GetMapping(path = "/asesores/{id}")
    public ResponseEntity<Asesor> getAsesorById(@PathVariable(value="id") Integer id){
        Optional<Asesor> c = this.asesorRepository.findById(id);
        if(c.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(c.get());
    }


    @PutMapping(path = "/asesores/{id}")
    public ResponseEntity<Asesor> updateAsesor(@PathVariable(value = "id") Integer id,
                                    @Valid  @RequestBody  Asesor a){

        Optional<Asesor> op = this.asesorRepository.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Asesor asesor = op.get();

        asesor.setNombre(a.getNombre());
        asesor.setEspecialidad(a.getEspecialidad());

        Asesor updated = this.asesorRepository.save(asesor);

        return ResponseEntity.ok(updated);

    }


    @DeleteMapping(path = "/asesores/{id}")
    public  ResponseEntity<Asesor> deleteAsesor(@PathVariable(value = "id") Integer id) {

        Optional<Asesor> op = this.asesorRepository.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        this.asesorRepository.delete(op.get());

        return ResponseEntity.ok().build();
    }

}
