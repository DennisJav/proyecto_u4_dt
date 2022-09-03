package com.uce.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "vistaListaEstudiantes";
	}
	
}
