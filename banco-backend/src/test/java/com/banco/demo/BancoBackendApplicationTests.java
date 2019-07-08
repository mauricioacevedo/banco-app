package com.banco.demo;


import com.banco.demo.entities.Asesor;
import com.banco.demo.entities.Cliente;

import com.banco.demo.entities.Tarjeta;
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

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@SpringBootTest
public class BancoBackendApplicationTests {//Unit tests!!!

	//@LocalServerPort
	//private int port;

	//TestRestTemplate restTemplate = new TestRestTemplate();

	//HttpHeaders headers = new HttpHeaders();

	/*@Test
	public void checkService() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/check"),
				HttpMethod.GET, entity, String.class);
		String answer= response.getBody();

		assertTrue(answer.contains("working"));
	}*/

	@Test
	public void createCliente(){
		Cliente c = new Cliente();
		c = null;
		assertNotNull(c);
	}

	@Test
	public void createTarjeta(){
		Tarjeta c = new Tarjeta();

		assertNotNull(c);
	}

	@Test
	public void createAsesor(){
		Asesor c = new Asesor();

		assertNotNull(c);
	}

/*
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
*/
}
