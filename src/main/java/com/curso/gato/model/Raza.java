package com.curso.gato.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Raza implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String origen;
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	private double pesoPromedio;
	private String descripcion;
	
	@OneToMany(mappedBy = "raza", cascade = CascadeType.PERSIST)
	private List<Gato> gatos;

	public Raza() {
		
	}
	public Raza(long id) {
		this.id = id;
	}
	
	public Raza(String nombre, String origen, Tamanho tamanho, double pesoPromedio, String descripcion) {
		this.nombre = nombre;
		this.origen = origen;
		this.tamanho = tamanho;
		this.pesoPromedio = pesoPromedio;
		this.descripcion = descripcion;
	}
	public Raza(long id, String nombre, String origen, Tamanho tamanho, double pesoPromedio, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.origen = origen;
		this.tamanho = tamanho;
		this.pesoPromedio = pesoPromedio;
		this.descripcion = descripcion;
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
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	public double getPesoPromedio() {
		return pesoPromedio;
	}
	public void setPesoPromedio(double pesoPromedio) {
		this.pesoPromedio = pesoPromedio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		Raza other = (Raza) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RazaGato [id=").append(id).append(", nombre=").append(nombre).append(", origen=").append(origen)
				.append(", tamanho=").append(tamanho).append(", pesoPromedio=").append(pesoPromedio)
				.append(", descripcion=").append(descripcion).append("]");
		return builder.toString();
	}
		
}
