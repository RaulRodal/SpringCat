package com.curso.gato.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.gato.dao.GatoDao;
import com.curso.gato.model.Gato;

@Service
public class GatoServiceImpl implements GatoService {

	@Autowired
	GatoDao dao;

	@Override
	public List<Gato> findAll() {
		return dao.findAll();
	}
	
	@Override
	public List<Gato> findAllJoin() {
		return dao.findAllJoin();
	}

	@Override
	public Optional<Gato> findById(long id) {
		return dao.findByIdJoin(id);
	}

	@Override
	public void insert(Gato gato) {
		dao.save(gato);
	}

	@Override
	public void update(Gato gato) {
		dao.save(gato);
	}

	@Override
	public void delete(long id) {
		dao.deleteById(id);
	}

	@Override
	public Double getEdad(long id) {
		return dao.getEdad(id);
	}
}
