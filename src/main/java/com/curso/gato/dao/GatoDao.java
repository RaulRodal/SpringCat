package com.curso.gato.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.gato.model.Gato;

public interface GatoDao extends JpaRepository<Gato, Long> {

	@Query("SELECT g FROM Gato g " + "JOIN FETCH g.raza raza")
	List<Gato> findAllJoin();
	
	@Query("SELECT g FROM Gato g " + "JOIN FETCH g.raza raza "+ "WHERE g.id = ?1")
	Optional<Gato> findByIdJoin(Long id);
	
	@Query(nativeQuery = true, value= "SELECT DATE_FORMAT(FROM_DAYS(DATEDIFF(now(),g.fecha_nacimiento)), '%Y')+0 FROM Gato g WHERE g.id = ?1")
	Double getEdad(Long id);
}
