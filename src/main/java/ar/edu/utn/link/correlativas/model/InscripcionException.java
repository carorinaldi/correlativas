package ar.edu.utn.link.correlativas.model;

public class InscripcionException extends RuntimeException {
	
	private Curso curso;
	private Alumno alumno;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public InscripcionException(String mensaje, Curso curso, Alumno alumno) {
		super(mensaje);
		this.curso = curso;
		this.alumno = alumno;
	}

	public InscripcionException() {
		// TODO Auto-generated constructor stub
	}

	public InscripcionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InscripcionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InscripcionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InscripcionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
