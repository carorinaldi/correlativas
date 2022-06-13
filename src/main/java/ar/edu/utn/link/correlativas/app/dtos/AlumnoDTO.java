package ar.edu.utn.link.correlativas.app.dtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.link.correlativas.model.Curso;
import ar.edu.utn.link.correlativas.model.Materia;

public interface AlumnoDTO {
	
	String getNombre();
	
	List<Curso> getCursos();
	
	@Value("#{target.nombre} #{target.apellido}")
	String getNombreCompleto();
	
	@Value("#{target.materiasAprobadas.size()}")
	int getCantMateriasAprobadas();
	
	@Value("#{target.materiasAprobadas}")
	List<Materia> getMateriasAprobadas();

}
