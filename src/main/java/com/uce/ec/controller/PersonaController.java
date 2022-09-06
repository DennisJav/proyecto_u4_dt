package com.uce.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.ec.modelo.Persona;
import com.uce.ec.service.IPersonaJpaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {

	
	@Autowired
	private IPersonaJpaService personaJpaService;
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Persona> lista = this.personaJpaService.buscarTodos();
		modelo.addAttribute("personas",lista);
		return "vistaListaPersonas";
	}
	
	@GetMapping("/buscarUno/{idPersona}")
	public String buscarPersona(@PathVariable("idPersona") Integer id, Model modelo) {
		
		Persona per=this.personaJpaService.buscarPersona(id);
		modelo.addAttribute("persona",per);
		
		return "VistaPersona";
	}
	
	@PutMapping("/actualizar/{idPersona}")
	public String actualizarPersona(@PathVariable("idPersona") Integer id, Persona persona) {
		
		persona.setId(id);
		this.personaJpaService.actualizarPersona(persona);
		
		return "redirect:/personas/buscar";
	}
	
	@DeleteMapping("/borrar/{idPersona}")
	public String borrarPersona(@PathVariable("idPersona") Integer id) {
		
		this.personaJpaService.eliminarPersona(id);
		
		return "redirect:/personas/buscar";
	}
	
	@PostMapping("/insertar")
	public String insertarPersona(Persona persona) {
		
		this.personaJpaService.crearPersona(persona);
		
		return"redirect:/personas/buscar";
	}
	
	//metodos de redireccionamiento a paginas
	@GetMapping("/nuevaPersona")
	public String paginaNuevaPersona(Persona persona) {
		return "vistaNuevaPersona";
	}
	
	
	
	
	
	
	
}
