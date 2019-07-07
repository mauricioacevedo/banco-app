package com.banco.demo;


import com.banco.demo.entities.Asesor;
import com.banco.demo.entities.Cliente;

import com.banco.demo.services.AsesorService;
import com.banco.demo.services.ClienteService;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BancoBackendApplicationTests {//Unit tests!!!

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private AsesorService asesorService;


	@Test
	public void saveCliente() throws Exception {

		Cliente cliente = new Cliente();
		cliente.setNombre("Juli");
		cliente.setCiudad("Medellin");
		cliente.setDireccion("Namek");
		cliente.setTelefono("00000");

		Cliente res=this.clienteService.save(cliente);

		assertNotNull(res);

		//ObjectMapper map = new ObjectMapper();
		/*String jsonClient=null;
		try {
			jsonClient = map.writeValueAsString(cliente);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}*/
	}

	@Test
	public void saveAsesor() throws Exception {

		Asesor asesor = new Asesor();
		asesor.setNombre("Camilo");
		asesor.setEspecialidad("Finanzas");

		Asesor res=this.asesorService.save(asesor);

		assertNotNull(res);

	}


}
