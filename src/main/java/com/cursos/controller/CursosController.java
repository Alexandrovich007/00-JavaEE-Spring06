package com.cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cursos.model.Curso;
import com.cursos.service.CursosService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CursosController {
	
	@Autowired
	CursosService service;
	/**
	 * Necesitamos vincular el objeto Curso con el formulario de alta
	 * Usando el @ModelAttribute se nos va volcar los datos directamente del form en java bean Curso
	 * @param curso
	 * @return
	 */
	@PostMapping("/alta")
	public String altaCurso(@ModelAttribute Curso curso) {
		
		service.nuevoCurso(curso);
		return "menu"; // Redirige a la vista del menú principal jsp
	}	

	@GetMapping("/recuperar")
	public String recuperarCurso(@RequestParam("idCurso") int idCurso, HttpServletRequest request) {
		Curso curso = service.buscarCurso(idCurso);
		request.setAttribute("curso", curso);
		return "curso"; // Redirige a la vista del curso jsp
	}
	
	// Movido desde abajo para probar conflicto
		@GetMapping("/eliminar")
		public String eliminarCurso(@RequestParam("idCurso") int idCurso) {
			service.eliminarCurso(idCurso);
			return "menuPrincipal"; 
		}
	
	@GetMapping("/recuperarActualizar")
	public String recuperarActualizarCurso(@RequestParam("idCurso") int idCurso, HttpServletRequest request) {
		Curso curso = service.buscarCurso(idCurso);
		request.setAttribute("curso", curso);
		return "cursoActualizar"; 
	}
	
	@PostMapping("/actualizar")
	public String actualizarCurso(@ModelAttribute Curso curso) {
		if(service.buscarCurso(curso.getIdCurso()) != null) {
			service.actualizarCurso(curso);
		}	
		return "menu";
	}
	
<<<<<<< HEAD
	
=======
	// Movido desde arriba para probar conflicto
	@GetMapping("/eliminar")
	public String eliminarCurso(@RequestParam("idCurso") int idCurso) {
		service.eliminarCurso(idCurso);
		return "menuDev"; 
	}
>>>>>>> develop_v1.0.0
	
}
