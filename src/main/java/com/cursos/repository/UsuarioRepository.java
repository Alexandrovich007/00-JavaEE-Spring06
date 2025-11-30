package com.cursos.repository;

import com.cursos.model.Usuario;

public interface UsuarioRepository {
	
	//Buscar un usuario por su nombre de usuario
	Usuario findByUsername(String username);	
	
	//Buscar un usuario por nombre de usuario y contraseña
	Usuario findByUsernameAndPassword(String username, String password);
	
	//Guardar un nuevo usuario
	void save(Usuario usuario);
	
	//Verificar si existe un usuario
	boolean existsByUsername(String username);

}
