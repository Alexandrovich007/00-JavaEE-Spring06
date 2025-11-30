package com.cursos.repository;

import org.springframework.stereotype.Repository;

import com.cursos.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
	// Inyectar el EntityManager para interactuar con la base de datos
	@PersistenceContext 
	private EntityManager em;

	@Override
	public Usuario findByUsername(String username) {
		try {
			return em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class)
					.setParameter("usrname", username)
					.getSingleResult();
		} catch (NoResultException e) {
			// Si no se encuentra el usuario, se devuelve null
			return null;
		}
		
	}

	@Override
	public Usuario findByUsernameAndPassword(String username, String password) {
		try {
			return em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password AND u.activo = true", Usuario.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
		} catch (NoResultException e) {
			// Si no se encuentra el usuario, se devuelve null
			return null;
		}		
	}

	@Override
	public void save(Usuario usuario) {
		em.persist(usuario);
	}
	
	//Útil para validar si un nombre de usuario ya existe en la base de datos
	@Override
	public boolean existsByUsername(String username) {
		Long count = em.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.username = :username", Long.class)
				.setParameter("username", username)
				.getSingleResult();
		return count > 0;
	}

}
