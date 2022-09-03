package com.uce.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.ec.modelo.Persona;
import com.uce.ec.repository.IPersonaJpaRepo;

@Service
public class IPersonaJpaServiceImpl implements IPersonaJpaService{

	@Autowired
	private IPersonaJpaRepo personaJpaRepo;
	
	@Override
	public void crearPersona(Persona persona) {
		// TODO Auto-generated method stub
		this.personaJpaRepo.crearPersona(persona);
	}

	@Override
	public Persona buscarPersona(Integer id) {
		// TODO Auto-generated method stub
		return this.personaJpaRepo.buscarPersonaCedula(id);
	}

	@Override
	public void eliminarPersona(Integer id) {
		// TODO Auto-generated method stub
		this.personaJpaRepo.eliminarPersona(id);
	}

	@Override
	public void actualizarPersona(Persona persona) {
		// TODO Auto-generated method stub
		this.personaJpaRepo.actualizarPersona(persona);
	}

	@Override
	public List<Persona> buscarTodos() {
		// TODO Auto-generated method stub
		return this.personaJpaRepo.buscarTodos();
	}



}
