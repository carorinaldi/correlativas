package ar.edu.utn.link.correlativas.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
public class Alumno {

	protected Alumno() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank
	private String nombre;

	public Alumno(Integer id, @NotBlank String nombre, String apellido, List<Curso> cursos,
			Collection<Materia> materiasAprobadas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cursos = cursos;
		this.materiasAprobadas = materiasAprobadas;
	}

	private String apellido;

	@ManyToMany
	private List<Curso> cursos;

	@ManyToMany
	private Collection<Materia> materiasAprobadas;

	public Alumno(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Collection<Materia> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(Collection<Materia> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void inscribir(Curso curso) {
		if (curso.estaInscripto(this)) {
			throw new InscripcionException("ya esta inscripto", curso, this);
		}
		curso.anotar(this);
	}

}
