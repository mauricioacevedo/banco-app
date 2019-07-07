package com.banco.demo.controllers;

import com.banco.demo.entities.Cliente;
import com.banco.demo.repositories.ClienteRepository;
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
public class ClienteController {

    private final ClienteRepository clienteRepository;


    @GetMapping(path = "/clientes")
    public List<Cliente> getAllClientes(){
        return this.clienteRepository.findAll();
    }

    @PostMapping(path = "/clientes")
    public Cliente createCliente(@Valid @RequestBody Cliente c){

        return this.clienteRepository.save(c);
    }

    @GetMapping(path = "/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable(value="id") Integer id){
        Optional<Cliente> c = this.clienteRepository.findById(id);
        if(c.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(c.get());
    }


    @PutMapping(path = "/clientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable(value = "id") Integer id,
                                    @Valid  @RequestBody  Cliente c){

        Optional<Cliente> op = this.clienteRepository.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = op.get();

        cliente.setNombre(c.getNombre());
        cliente.setCiudad(c.getCiudad());
        cliente.setDireccion(c.getDireccion());
        cliente.setTelefono(c.getTelefono());

        Cliente updated = this.clienteRepository.save(cliente);

        return ResponseEntity.ok(updated);

    }


    @DeleteMapping(path = "/clientes/{id}")
    public  ResponseEntity<Cliente> deleteCliente(@PathVariable(value = "id") Integer id) {

        Optional<Cliente> op = this.clienteRepository.findById(id);
        if(op.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        this.clienteRepository.delete(op.get());

        return ResponseEntity.ok().build();
    }

}
