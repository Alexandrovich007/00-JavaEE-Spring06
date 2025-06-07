package com.cursos.repository;

import org.springframework.transaction.annotation.Transactional;

import com.cursos.model.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CursosRepositoryImpl implements CursosRepository {
	
	@PersistenceContext(unitName = "cursosPU")
	EntityManager em;
	
	/**
	 * 	Transacciones con JPA y Spring:
	 * 	1. Gestión automática de transacciones de base de datos:
		2. Inicia una transacción antes de ejecutar el método
		3. Confirma (commit) la transacción si el método termina correctamente
		4. Revierte (rollback) la transacción si ocurre una excepción
	 */
	
	@Transactional
	@Override
	public void altaCurso(Curso curso) {
		em.persist(curso);

	}

	@Override
	public Curso buscarCursoPorId(int idCurso) {
		// TODO Auto-generated method stub
		return em.find(Curso.class, idCurso);
	}

	@Override
	public void eliminarCurso(Curso curso) {
		
		//em.remove(buscarCursoPorId(curso.getIdCurso()));
		/**
		 * em.contains(curso) verifica si la entidad está managed (Son entidades conectadas y rastreadas por el EntityManager activo)
			•  Si está managed: se elimina directamente
			•  Si está detached (No vinculadas al EntityManager): primero se reconecta con merge() y luego se elimina.
			Este patrón garantiza que la operación funcione correctamente sin importar el estado de la entidad.
		 */
		
		if(curso != null) {
			em.remove(em.contains(curso) ? curso : em.merge(curso));
		} else {
			throw new IllegalArgumentException("El curso no puede ser nulo");
		}
	}
	@Transactional
	@Override
	public void actualizarCurso(Curso curso) {
		em.merge(curso);

	}

}
