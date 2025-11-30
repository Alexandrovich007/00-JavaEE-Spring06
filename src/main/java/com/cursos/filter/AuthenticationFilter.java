package com.cursos.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*") // Aplica el filtro a todas las rutas
public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//Convertimos ServletRequest a HttpServletRequest para acceder a métodos HTTP
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		
		//Obtener la ruta solicitada
		String requestUri = httpRequest.getRequestURI();
		String contextPath = httpRequest.getContextPath();
		//Definir las páginas públicas que no requieren autenticación
		boolean isPublicPage = 
//				requestUri.equals(contextPath + "/") ||
				requestUri.equals(contextPath + "/login") ||
				requestUri.equals(contextPath + "/registro") ||
				requestUri.startsWith(contextPath + "/css/") || 
				requestUri.startsWith(contextPath + "/js/") ||
				requestUri.startsWith(contextPath + "/images/") ||
				requestUri.endsWith(".ico");
		//Verificar si el usuario está autenticado
		boolean isLoggedIn = (session != null && session.getAttribute("usuarioLogueado") != null);
		
		if(isPublicPage || isLoggedIn) {
			//El usuario está autenticado o accediendo a una página pública
			chain.doFilter(request, response); //Permitir el acceso
		} else {
			//El usuario no está autenticado y está intentando acceder a una página protegida
			httpResponse.sendRedirect(contextPath + "/login?accesoRestringido=true"); //Redirigir al login
		}
	}

}
