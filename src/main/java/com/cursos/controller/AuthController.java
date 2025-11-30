package com.cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cursos.model.Usuario;
import com.cursos.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	@Autowired
	private UsuarioService usuarioService;
	
//	@GetMapping("/")
//	public ModelAndView inicio() {
//		return new ModelAndView("redirect:/login");
//	}
	
	@GetMapping("/login")
	public String mostrarLogin() {
		return "login"; // Retorna la vista de login
	}
	
	@PostMapping("/login")
	public ModelAndView procesarLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		Usuario usuario = usuarioService.autenticar(username, password);
		
		if(usuario != null) {
			session.setAttribute("usuarioLogueado", usuario);
			mav.setViewName("redirect:/menu"); // Redirige al menú principal
		} else {
			mav.addObject("error", "Credenciales inválidas o usuario inactivo");
			mav.setViewName("login"); 
		}
		
		return mav;		
	}
	
	@GetMapping("/registro")
	public ModelAndView mostrarRegistro() {
		return new ModelAndView("registro");
	}
	
	@PostMapping("/registro")
	public ModelAndView procesarRegistro(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
		
		ModelAndView mav = new ModelAndView();
		Usuario nuevoUsuario = new Usuario(username, password, email);
		
		try {
			boolean registrado = usuarioService.registrar(nuevoUsuario);
			
			if(registrado) {
				mav.addObject("mensaje", "Registro exitoso. Ahora puedes iniciar sesión.");
				mav.setViewName("login");
			} else {
				mav.addObject("error", "El nombre de usuario ya existe.");
				mav.setViewName("registro");
			}
		} catch (Exception e) {
			mav.addObject("error", "Error al registrar el usuario." + e.getMessage());
			mav.setViewName("registro");
		}
		
		return mav;	
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate(); // Destruir la sesión
		return new ModelAndView("redirect:/login");
	}
	
}
