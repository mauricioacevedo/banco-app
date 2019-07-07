package com.banco.demo.repositories;

import com.banco.demo.entities.Asesor;
import com.banco.demo.entities.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor,Integer> {

}
