package ar.edu.utn.link.correlativas.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="cursos")
public interface RepoCurso extends PagingAndSortingRepository<Curso, Integer>{


}
