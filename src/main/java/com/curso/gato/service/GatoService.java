package com.curso.gato.service;

import java.util.List;

import com.curso.gato.model.Gato;

public interface GatoService {
	List<Gato> findAll();
	Gato findOne(long id);
	void insert(Gato gato);
	void update(Gato gato);
	void delete(Gato gato);
}
