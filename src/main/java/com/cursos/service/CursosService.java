package com.cursos.service;

import java.util.List;

import com.cursos.model.Curso;

public interface CursosService {
	
	void nuevoCurso(Curso curso);
	
	Curso buscarCurso(int idCurso);
	
	void actualizarCurso(Curso curso);
	
	void eliminarCurso(int idCurso);
	
	List<Curso> cursosDuracionMax(int duracion);
	
	void reducirPrecioCursos(int duracion, int porcentajeDescuento);

}
