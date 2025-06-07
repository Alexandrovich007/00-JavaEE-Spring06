package com.cursos.repository;

import com.cursos.model.Curso;

public interface CursosRepository {
	
	void altaCurso(Curso curso);
	
	Curso buscarCursoPorId(int idCurso);
	
	void eliminarCurso(Curso curso);
	
	void actualizarCurso(Curso curso);

}
