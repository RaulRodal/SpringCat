package com.curso.gato.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Gato implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String nombre;
	private String raza;
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	public Gato() {
	}
		
	public Gato(String nombre) {
		this.nombre = nombre;
	}
	
	public Gato(String nombre, String raza, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.raza = raza;
		this.fechaNacimiento = fechaNacimiento;
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
		return Objects.hash(nombre);
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
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Gato [nombre=").append(nombre).append(", raza=").append(raza).append(", fecha de nacimiento=").append(fechaNacimiento)
				.append("]");
		return builder.toString();
	}
	
}
