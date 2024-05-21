package com.curso.gato.controller;

import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.gato.model.Gato;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@RestController
@RequestMapping(path = "cat")
public class HomeController {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("cat");
	EntityManager em = emf.createEntityManager();
	
	@GetMapping(value = "{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Gato obtener(@PathVariable String nombre) {
		return em.find(Gato.class, nombre);
	}
	
	@PostMapping(value = "insert")
	public void insertar(@RequestParam("nombre") String nombre, @RequestParam("raza") String raza, @RequestParam("fecha") String fecha) {
		Gato gato = new Gato(nombre, raza, LocalDate.parse(fecha));
		em.getTransaction().begin();
		em.persist(gato);
		em.getTransaction().commit();
	}
}
