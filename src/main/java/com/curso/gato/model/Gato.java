package com.curso.gato.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gato implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String raza;
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	public Gato() {
	}
		
	public Gato(long id) {
		this.id = id;
	}
	
	public Gato(String nombre, String raza, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.raza = raza;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Gato(long id, String nombre, String raza, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gato other = (Gato) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Gato [id=").append(id).append(", nombre=").append(nombre).append(", raza=").append(raza)
				.append(", fechaNacimiento=").append(fechaNacimiento).append("]");
		return builder.toString();
	}
	
}
