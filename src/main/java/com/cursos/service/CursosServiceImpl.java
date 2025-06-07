package com.cursos.service;
import org.springframework.beans.factory.annotation.Autowired;

import com.cursos.model.Curso;
import com.cursos.repository.CursosRepository;

public class CursosServiceImpl implements CursosService {
	
	@Autowired
	CursosRepository repository;

	@Override
	public void nuevoCurso(Curso curso) {
		
		repository.altaCurso(curso);

	}

	@Override
	public Curso buscarCurso(int idCurso) {
		
		return repository.buscarCursoPorId(idCurso);
	}

	@Override
	public void actualizarCurso(Curso curso) {
		
		if(buscarCurso(curso.getIdCurso()) != null) {
			repository.actualizarCurso(curso);
		}		

	}

	@Override
	public void eliminarCurso(int idCurso) {
		Curso curso = buscarCurso(idCurso);
		if(curso != null) {
			repository.eliminarCurso(curso);
		}

	}

}
