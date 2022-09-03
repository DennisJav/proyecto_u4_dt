package com.uce.ec.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "persona")

//NAMED QUERY
@NamedQuery(name = "Persona.buscarPorCedula", query = "select p from Persona p where p.cedula = :valoruno")
@NamedQuery(name = "Persona.buscarPorNombreApellido", query = "select p from Persona p where p.nombre = :valoruno AND p.apellido = :valordos")
//NATIVE QUERY
//Esta declaracion es antigua 
//@NamedQueries({
//	@NamedQuery(name = "Persona.buscarPorCedula", query = "select p from Persona p where p.cedula = :valoruno"),
//	@NamedQuery(name = "Persona.buscarPorNombreApellido", query = "select p from Persona p where p.nombre = :valoruno AND p.apellido = :valordos")
//})
@NamedNativeQuery(name = "Persona.buscarPorCedulaNative", query = "select * from persona where pers_cedula =:valoruno",resultClass = Persona.class)
//CRITERIA API QUERY


public class Persona {

	@Id
	@Column(name = "pers_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "per_sec_id")
	@SequenceGenerator(name = "per_sec_id", sequenceName = "per_sec_id", allocationSize = 1)
	private Integer id;
	@Column(name = "pers_nombre")
	private String nombre;
	@Column(name = "pers_apellido")
	private String apellido;
	@Column(name = "pers_cedula")
	private String cedula;
	@Column(name = "pers_genero")
	private String genero;

	
	
	
	
	// set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + "]";
	}

}
