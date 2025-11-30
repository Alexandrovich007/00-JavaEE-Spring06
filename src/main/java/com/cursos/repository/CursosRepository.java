package com.cursos.repository;

import java.util.List;

import com.cursos.model.Curso;

public interface CursosRepository {
	
	void altaCurso(Curso curso);
	
	Curso buscarCursoPorId(int idCurso);
	
	void eliminarCurso(Curso curso);
	
	void actualizarCurso(Curso curso);
	
	List<Curso> cursosDuracion(int duracion);
	
	void eliminarCursosNombre(String nombreCurso);
	
	void reducirPrecioCursos(int duracion, int porcentajeDescuento);

}
