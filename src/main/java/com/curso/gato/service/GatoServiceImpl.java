package com.curso.gato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.gato.model.Gato;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Service
public class GatoServiceImpl implements GatoService {

	EntityManagerFactory emf;
	EntityManager entityManager;
	
	public GatoServiceImpl() {
		emf = Persistence.createEntityManagerFactory("cat");
		entityManager = emf.createEntityManager();
	}

	@Override
	public List<Gato> findAll() {
		return entityManager.createQuery("SELECT g FROM Gato g").getResultList();
	}

	@Override
	public Gato findOne(long id) {
		return entityManager.find(Gato.class, id);
	}

	@Override
	public void insert(Gato gato) {
		entityManager.getTransaction().begin();
		entityManager.persist(gato);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(Gato gato) {
		entityManager.getTransaction().begin();
		Gato updateGato = findOne(gato.getId());
		if (updateGato != null) {
			updateGato.setNombre(gato.getNombre());
			updateGato.setRaza(gato.getRaza());
			updateGato.setFechaNacimiento(gato.getFechaNacimiento());
			
		}
		entityManager.getTransaction().commit();
	}

	@Override
	public void delete(Gato gato) {
		entityManager.getTransaction().begin();
		Gato deleteGato = entityManager.find(Gato.class, gato.getId());
		entityManager.remove(deleteGato);
		entityManager.getTransaction().commit();
	}

}
