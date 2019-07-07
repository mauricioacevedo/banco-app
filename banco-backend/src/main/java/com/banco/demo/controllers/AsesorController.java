package com.banco.demo.controllers;

import com.banco.demo.entities.Asesor;
import com.banco.demo.entities.Asesor;
import com.banco.demo.repositories.AsesorRepository;
import com.banco.demo.repositories.AsesorRepository;
import com.banco.demo.services.AsesorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
public class AsesorController {

    private AsesorService asesorService;


    @GetMapping(path = "/asesores")
    public List<Asesor> getAllAsesores(){
        return this.asesorService.findAll();
    }

    @PostMapping(path = "/asesores")
    public Asesor createAsesor(@Valid @RequestBody Asesor c){

        return this.asesorService.save(c);
    }

    @GetMapping(path = "/asesores/{id}")
    public ResponseEntity<Asesor> getAsesorById(@PathVariable(value="id") Integer id){
        Optional<Asesor> c = this.asesorService.findById(id);
        if(c.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(c.get());
    }


    @PutMapping(path = "/asesores/{id}")
    public ResponseEntity<Asesor> updateAsesor(@PathVariable(value = "id") Integer id,
                                    @Valid  @RequestBody  Asesor a){

        Optional<Asesor> op = this.asesorService.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Asesor asesor = op.get();

        asesor.setNombre(a.getNombre());
        asesor.setEspecialidad(a.getEspecialidad());

        Asesor updated = this.asesorService.save(asesor);

        return ResponseEntity.ok(updated);

    }


    @DeleteMapping(path = "/asesores/{id}")
    public  ResponseEntity<Asesor> deleteAsesor(@PathVariable(value = "id") Integer id) {

        Optional<Asesor> op = this.asesorService.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        this.asesorService.delete(op.get());

        return ResponseEntity.ok().build();
    }

}
