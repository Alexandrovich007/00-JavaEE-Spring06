package com.cursos.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.model.Curso;
import com.cursos.repository.CursosRepository;

@Service
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

	@Override
	public List<Curso> cursosDuracionMax(int duracion) {
		 
		return repository.cursosDuracion(duracion);
	}

	@Override
	public void reducirPrecioCursos(int duracion, int porcentajeDescuento) {
		
		repository.reducirPrecioCursos(duracion, porcentajeDescuento);
		
	}

}
