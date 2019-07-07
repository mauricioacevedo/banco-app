package com.banco.demo.controllers;

import com.banco.demo.entities.Tarjeta;

import com.banco.demo.services.TarjetaService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
public class TarjetaController {

    private TarjetaService tarjetaRepository;

    @GetMapping(path = "/tarjetas")
    public List<Tarjeta> getAllTarjetas(){
        return this.tarjetaRepository.findAll();
    }

    @PostMapping(path = "/tarjetas")
    public Tarjeta createTarjeta(@Valid @RequestBody Tarjeta c){

        return this.tarjetaRepository.save(c);
    }

    @GetMapping(path = "/tarjetas/{id}")
    public ResponseEntity<Tarjeta> getTarjetaById(@PathVariable(value="id") Integer id){
        Optional<Tarjeta> c = this.tarjetaRepository.findById(id);
        if(c.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(c.get());
    }


    @PutMapping(path = "/tarjetas/{id}")
    public ResponseEntity<Tarjeta> updateTarjeta(@PathVariable(value = "id") Integer id,
                                                 @Valid  @RequestBody  Tarjeta t){

        Optional<Tarjeta> op = this.tarjetaRepository.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Tarjeta tarjeta = op.get();

        tarjeta.setCcv(t.getCcv());
        //tarjeta.setCliente(t.getCliente());
        tarjeta.setTipo(t.getTipo());
        tarjeta.setEstadoTarjeta(t.getEstadoTarjeta());
        //Las fechas de creacion y vencimiento no se deben actualizar
        tarjeta.setNumeroTarjeta(t.getNumeroTarjeta());
        //pienso que el numero de la tarjeta tampoco se deberia modificar..

        Tarjeta updated = this.tarjetaRepository.save(tarjeta);

        return ResponseEntity.ok(updated);

    }


    @DeleteMapping(path = "/tarjetas/{id}")
    public  ResponseEntity<Tarjeta> deleteTarjeta(@PathVariable(value = "id") Integer id) {

        Optional<Tarjeta> op = this.tarjetaRepository.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        this.tarjetaRepository.delete(op.get());

        return ResponseEntity.ok().build();
    }
}
