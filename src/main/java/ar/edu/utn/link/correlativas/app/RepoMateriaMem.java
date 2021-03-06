package ar.edu.utn.link.correlativas.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import ar.edu.utn.link.correlativas.model.Materia;

@Repository
public class RepoMateriaMem implements RepoMateria {
	private Collection<Materia> materias;

	public RepoMateriaMem() {
		super();
		List<Materia> of = List.of(new Materia("Algoritmos",1), new Materia("Sintaxis",2), new Materia("Paradigmas",2), new Materia("SO",3));
		materias = new ArrayList<Materia>(of);
	}
	
	public Collection<Materia> all() {
		return materias;
	}

	public Materia findByName(String nombreMateria) {
		return materias.stream().filter(materia->materia.getNombre().equals(nombreMateria)).findFirst().get();
	}

	public Collection<Materia> findByYear(Integer anio) {
		return materias.stream().filter(materia->materia.getAnio().equals(anio)).collect(Collectors.toList());
	}



	@Override
	public <S extends Materia> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Materia> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Materia> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Materia entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Materia> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Materia> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Materia findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Materia findByNombreAndAnio(String nombre, Integer anio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Materia> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Materia> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Materia> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Materia> findByAnio(Integer anio, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}



}
