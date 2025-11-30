package com.cursos.controller;

import java.util.List;

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
	/**
	 * Recupera un curso para actualizarlo.
	 * @param idCurso
	 * @param request
	 * @return
	 */
	@GetMapping("/recuperarActualizar")
	public String recuperarActualizarCurso(@RequestParam("idCurso") int idCurso, HttpServletRequest request) {
		Curso curso = service.buscarCurso(idCurso);
		request.setAttribute("curso", curso); //El nombre del atributo o clave ("curso") es lo que usaremos en el JSP requestScope.curso para acceder al objeto Curso
		return "cursoActualizar"; 
	}
	/**
	 * Actualiza un curso existente.
	 * @param curso
	 * @return
	 */
	@PostMapping("/actualizar")
	public String actualizarCurso(@ModelAttribute Curso curso) {
		if(service.buscarCurso(curso.getIdCurso()) != null) {
			service.actualizarCurso(curso);
		}	
		return "menu";
	}
	
	@PostMapping("/descuentoCurso")
	public String reducirPrecioCurso(@RequestParam("duracion") int duracion, @RequestParam("porcentaje") int porcentaje) {
		
		service.reducirPrecioCursos(duracion, porcentaje); 		
		return "menu";
	}
	
	// Movido desde arriba para probar conflicto
	@GetMapping("/eliminar")
	public String eliminarCurso(@RequestParam("idCurso") int idCurso) {
		service.eliminarCurso(idCurso);
		return "menu"; 
	}
	
	@GetMapping("/cursosDuracion")
	public String cursosPorDuracion(@RequestParam("duracion") int duracion, HttpServletRequest request) {
		List<Curso> cursos = service.cursosDuracionMax(duracion);
		request.setAttribute("cursos", cursos);
		return "listaCursosDuracion"; // Redirige a la vista de cursos por duración jsp
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu"; 
	}
	
}
