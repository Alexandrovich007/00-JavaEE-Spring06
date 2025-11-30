package com.cursos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursos.model.Usuario;
import com.cursos.repository.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario autenticar(String username, String password) {
		Usuario usuario = usuarioRepository.findByUsernameAndPassword(username, password);
		return usuario;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean registrar(Usuario usuario) {
		if(usuarioRepository.existsByUsername(usuario.getUsername())) {
			return false; // El nombre de usuario ya existe
		}
		
		try {
			usuarioRepository.save(usuario);
			return true; // Registro exitoso
			} catch (Exception e) {
				return false; // Error al guardar el usuario
		}
	}

	@Override
	public boolean existeUsuario(String username) {
		// Verificar si el usuario existe en el repositorio
		return usuarioRepository.existsByUsername(username);
	}

}
