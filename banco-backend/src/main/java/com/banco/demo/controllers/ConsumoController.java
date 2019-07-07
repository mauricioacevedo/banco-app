package com.banco.demo.controllers;

import com.banco.demo.entities.Consumo;
import com.banco.demo.repositories.ConsumoRepository;
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
public class ConsumoController {

    private final ConsumoRepository consumoRepository;

    @GetMapping(path = "/consumos")
    public List<Consumo> getAllConsumos(){
        return this.consumoRepository.findAll();
    }

    @PostMapping(path = "/consumos")
    public Consumo createConsumo(@Valid @RequestBody Consumo c){

        return this.consumoRepository.save(c);
    }

    @GetMapping(path = "/consumos/{id}")
    public ResponseEntity<Consumo> getConsumoById(@PathVariable(value="id") Integer id){
        Optional<Consumo> c = this.consumoRepository.findById(id);
        if(c.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(c.get());
    }


    @PutMapping(path = "/consumos/{id}")
    public ResponseEntity<Consumo> updateConsumo(@PathVariable(value = "id") Integer id,
                                                 @Valid  @RequestBody  Consumo c){

        Optional<Consumo> op = this.consumoRepository.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Consumo consumo = op.get();

        consumo.setCuotas(c.getCuotas());
        consumo.setDescripcion(c.getDescripcion());
        consumo.setFechaConsumo(c.getFechaConsumo());
        consumo.setMonto(c.getMonto());
        consumo.setTarjetaId(c.getTarjetaId());

        Consumo updated = this.consumoRepository.save(consumo);

        return ResponseEntity.ok(updated);

    }

    @DeleteMapping(path = "/consumos/{id}")
    public  ResponseEntity<Consumo> deleteConsumo(@PathVariable(value = "id") Integer id) {

        Optional<Consumo> op = this.consumoRepository.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        this.consumoRepository.delete(op.get());

        return ResponseEntity.ok().build();
    }


    @GetMapping(path = "/consumos/detalles/{id}")
    public List<Consumo> getConsumosByTarjeta(@PathVariable(value="id") Integer tarjetaId){

        return this.consumoRepository.findConsumosByTarjeta(tarjetaId);

    }
}
