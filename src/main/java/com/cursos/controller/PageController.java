package com.cursos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
/**
 * Tecnica que permite tener una sola vista de busqueda que se adapta 
 * dinamicamente a la operacion que se va a realizar posteriormente.
 * Usa la url para determinar a que endpoint debe enviar los datos del form.
 * Acción final: Cuando el usuario envíe el formulario desde la página de búsqueda, 
 * probablemente se dirigirá al endpoint /toEliminar con los parámetros de búsqueda.
 */

@Controller
public class PageController {
	@GetMapping("/toEliminar")
	public String paraEliminar(HttpServletRequest request) {
		request.setAttribute("url", "eliminar"); //Permite indicar el ednpoint al que se enviará el formulario
		return "buscador";
		
	}
	
	@GetMapping(value="/toRecuperar")
	public String paraRecuperar(HttpServletRequest request) {
		request.setAttribute("url", "recuperar"); 
		return "buscador";
		
	}
	
	@GetMapping(value="/toActualizar")
	public String paraActualizar(HttpServletRequest request) {
		request.setAttribute("url", "recuperarActualizar"); 
		return "buscador";
	}
}

