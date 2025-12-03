package com.cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cursos.model.Usuario;
import com.cursos.service.UsuarioService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	@Autowired
	private UsuarioService usuarioService;
	
//	@GetMapping("/")
//	public ModelAndView inicio() {
//		return new ModelAndView("redirect:/login");
//	}
	
	/**
	 * @CookieValue: Lee automáticamente la cookie del navegador
	 * - defaultValue = "": Si no existe la cookie, usa cadena vacía
  	 * - Pasa el valor a la vista para prellenar el campo
	 * @param usuarioRecordado
	 * @return
	 */
	@GetMapping("/login")
	public ModelAndView mostrarLogin(@CookieValue(value = "usuarioRecordado", defaultValue = "") String usuarioRecordado) {
		ModelAndView mav = new ModelAndView("login");
		
		if(!usuarioRecordado.isEmpty()) {
			mav.addObject("usuarioRecordado", usuarioRecordado);
		}
		return mav; // Retorna la vista de login
	}
	
	@PostMapping("/login")
	public ModelAndView procesarLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam(value = "recordar", required = false) String recordar, HttpSession session, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		Usuario usuario = usuarioService.autenticar(username, password);
		
		if(usuario != null) {
			session.setAttribute("usuarioLogueado", usuario);
			// Manejar la cookie de "recordar usuario"
			if(recordar != null && recordar.equals("on")) {
				// Crear cookie para recordar el usuario
				Cookie cookieUsuario = new Cookie("usuarioRecordado", username);
				cookieUsuario.setMaxAge(30 * 60); // 30 minutos
				cookieUsuario.setPath("/"); // Disponible en toda la aplicación
				cookieUsuario.setHttpOnly(false); // Permitir acceso desde JavaScript si es necesario
				//Para enviar una cookie al usuario, se construye un objeto Cookie y se añade a la respuesta
				response.addCookie(cookieUsuario);
			} else {
				// Si no se selecciona "recordar", eliminar la cookie si existe
				Cookie cookieUsuario = new Cookie("usuarioRecordado", "");
				cookieUsuario.setMaxAge(0); // Eliminar la cookie
				cookieUsuario.setPath("/");
				response.addCookie(cookieUsuario);
			}			
			
			mav.setViewName("redirect:/menu"); // Redirige al menú principal
		} else {
			mav.addObject("error", "Credenciales inválidas o usuario inactivo");
			mav.addObject("usuarioIntentado", username); // Para rellenar el campo username
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
