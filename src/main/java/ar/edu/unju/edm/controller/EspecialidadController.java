package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Especialidad;
import ar.edu.unju.edm.service.EspecialidadService;

@Controller
public class EspecialidadController {
	@Autowired 
	EspecialidadService especialidadSer; 
	@Autowired 
	Especialidad unaEsp; 
	
	@GetMapping ("/")
	public ModelAndView cargarEspecialidad () {
		ModelAndView form= new ModelAndView ("formulario"); 
		form.addObject("especialidad", unaEsp); 
		return form; 
		
	}
	@PostMapping ("/cargarEspecialidad")
	public ModelAndView guardarEspecialidad (@ModelAttribute ("especialidad") Especialidad especialidadConDatos) {
		ModelAndView listado=new ModelAndView ("listado"); 
		especialidadSer.cargarEspecialidad(especialidadConDatos); 
		return listado; 
	}
	
	

}
