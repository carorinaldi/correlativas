package ar.edu.utn.link.correlativas.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ar.edu.utn.link.correlativas.model.Curso;
import ar.edu.utn.link.correlativas.model.Materia;

@Repository
public class RepoCursoMem {
	private Collection<Curso> cursos;

	public RepoCursoMem() {
		super();
		List<Curso> of = List.of(new Curso(new Materia("Algoritmos",1), 2022), new Curso(new Materia("Sintaxis",2),2021),new Curso(new Materia("Sintaxis",2),2022), new Curso(new Materia("Paradigmas",2),2022), new Curso(new Materia("SO",3),2021));
		cursos = new ArrayList<Curso>(of);
	}
	
	public Collection<Curso> all() {
		return cursos;
	}

	public Collection<Curso> findByYear(Integer anio) {
		return cursos.stream().filter(curso->curso.getAnio()==anio).collect(Collectors.toList());
	}

	public Curso findByName(String nombreCurso) {
		return cursos.stream().filter(curso->curso.getMateria().getNombre().equals(nombreCurso)).findFirst().get();
	}

	public void save(Curso curso) throws CursoRepetidoException{
		if(cursos.contains(curso)) {
			throw new CursoRepetidoException(curso);
		}
		this.cursos.add(curso);
		
	}
		

}
