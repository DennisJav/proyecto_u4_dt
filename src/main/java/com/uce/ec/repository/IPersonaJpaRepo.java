package com.uce.ec.repository;

import java.util.List;

import com.uce.ec.modelo.Persona;

public interface IPersonaJpaRepo {

	void crearPersona(Persona persona);

	Persona buscarPersonaCedula(Integer id);

	void eliminarPersona(Integer id);

	void actualizarPersona(Persona persona);
	
	public List<Persona> buscarTodos();
	

}
