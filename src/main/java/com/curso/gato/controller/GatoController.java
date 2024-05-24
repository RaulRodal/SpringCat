package com.curso.gato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.gato.model.Gato;
import com.curso.gato.service.GatoService;

@RestController
@RequestMapping(path = "cats")
public class GatoController {
	
	@Autowired
	GatoService gatoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Gato> findAll() {
		return gatoService.findAllJoin();
	}
	
	@GetMapping(value="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Gato findOne(@PathVariable long id) {
		return gatoService.findById(id).orElse(null);
	}
	@GetMapping(value="edad/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getEdad(@PathVariable long id) {
		return gatoService.getEdad(id).toString();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void insert(@RequestBody Gato gato) {
		gatoService.insert(gato);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Gato gato) {
		gatoService.update(gato);
	}
	
	@DeleteMapping(value="{id}")
	public void delete(@PathVariable long id) {
		gatoService.delete(id);
	}
}
