package com.curso.gato.service;

import java.util.List;
import java.util.Optional;

import com.curso.gato.model.Gato;

public interface GatoService {
	List<Gato> findAll();
	List<Gato> findAllJoin();
	Optional<Gato> findById(long id);
	void insert(Gato gato);
	void update(Gato gato);
	void delete(long id);
	Double getEdad(long id);
}
