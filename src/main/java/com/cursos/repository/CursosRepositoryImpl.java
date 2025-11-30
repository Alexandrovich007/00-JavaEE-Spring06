package com.cursos.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursos.model.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
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
	@Transactional
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

	@Override
	public List<Curso> cursosDuracion(int duracion) {
		// String jpql = "select c from Curso c where c.duracion <= ?1";
		TypedQuery<Curso> query=em.createNamedQuery("Curso.findByDuracion", Curso.class); //TypedQuery permite obtener una lista de resultados tipada
		query.setParameter(1, duracion);
		List<Curso> cursos = query.getResultList();
		return cursos;
	}

	@Transactional
	@Override
	public void eliminarCursosNombre(String nombreCurso) {
		
		//EntityTransaction tx = em.getTransaction();
		String jpql = "delete from Curso c where c.denominacion like ?1"; //?1 es un parámetro posicional que desconoce el valor al momento de ejecutar la consulta
		Query query = em.createQuery(jpql); //Query es cuando NO se espera que se retorne un resultado, sino que se ejecuta una acción como eliminar o actualizar.
		query.setParameter(1, "%" + nombreCurso + "%"); //Se usa el comodín % para buscar coincidencias parciales
		//tx.begin(); //Inicia la transacción
		query.executeUpdate(); //executeUpdate() se usa para ejecutar consultas de actualización o eliminación, devuelve el número de filas afectadas.
		//tx.commit(); //Confirma la transacción
		
	}
	@Transactional
	@Override
	public void reducirPrecioCursos(int duracion, int porcentajeDescuento) {
		
	//	EntityTransaction tx = em.getTransaction();
		String jpql = "update Curso c set c.precio = c.precio * ((100 - ?1) / 100) where c.duracion >= ?2";
		Query query = em.createQuery(jpql);
		query.setParameter(1, porcentajeDescuento);
		query.setParameter(2, duracion);
	//	tx.begin(); //Inicia la transacción
		query.executeUpdate(); 
	//	tx.commit(); //Confirma la transacción
		
	}

}
