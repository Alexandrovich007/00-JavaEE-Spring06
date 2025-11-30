package com.cursos.service;

import com.cursos.model.Usuario;

public interface UsuarioService {
	
	Usuario autenticar(String username, String password);
	
	boolean registrar(Usuario usuario);
	
	boolean existeUsuario(String username);

}
