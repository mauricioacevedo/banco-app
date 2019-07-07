package com.banco.demo.services;

import com.banco.demo.entities.Cliente;
import com.banco.demo.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Component
public class ClienteService {

    private ClienteRepository clienteRepository;


    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public Cliente save(Cliente c) {
        return this.clienteRepository.save(c);
    }

    public Optional<Cliente> findById(Integer id) {
        return this.clienteRepository.findById(id);
    }

    public void delete(Cliente cliente) {
        this.clienteRepository.delete(cliente);
    }
}
