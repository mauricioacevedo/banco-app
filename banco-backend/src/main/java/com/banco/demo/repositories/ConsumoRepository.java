package com.banco.demo.repositories;

import com.banco.demo.entities.Cliente;
import com.banco.demo.entities.Consumo;
import com.banco.demo.entities.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoRepository extends JpaRepository<Consumo,Integer> {

    @Query("From Consumo c where c.tarjetaId = ?1")
    List<Consumo> findConsumosByTarjeta(Integer tarjetaId);
}
