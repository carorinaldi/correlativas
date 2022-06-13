package ar.edu.utn.link.correlativas.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Materia materia;
	private boolean abierto;
	private int anio;
	
	@ManyToMany
	private Set<Alumno> inscriptos;

	public Curso(Materia materia, int anio) {
		this.materia = materia;
		this.anio = anio;
		this.inscriptos = new HashSet<Alumno>();
	}

	public Curso() {
		super();
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Set<Alumno> getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(Set<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}

	public boolean estaInscripto(Alumno alumno) {
		return this.getInscriptos().contains(alumno);
	}

	public void inscribir(Alumno alumno) throws Exception {
		if(this.estaInscripto(alumno)) {
			throw new Exception("No se puede inscribir a " + alumno + " porque ya se encuentra inscripto");		
		} else if(materia.cumpleCorrelativas(alumno.getMateriasAprobadas())) {
			this.inscriptos.add(alumno);
		}
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(abierto, anio, inscriptos, materia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return abierto == other.abierto && anio == other.anio && Objects.equals(inscriptos, other.inscriptos)
				&& Objects.equals(materia, other.materia);
	}

	@Override
	public String toString() {
		return "Curso [materia=" + materia + ", abierto=" + abierto + ", anio=" + anio + ", inscriptos=" + inscriptos
				+ "]";
	}

	public void anotar(Alumno alumno) {
		this.inscriptos.add(alumno);
		
	}
	
}
