package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Curso;

public class CursoRepetidoException extends Exception {

	private Curso curso;

	public CursoRepetidoException(Curso curso) {
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public CursoRepetidoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CursoRepetidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CursoRepetidoException(String message, Throwable cause) {
		super(message, cause);

	}

	public CursoRepetidoException(String message) {
		super(message);
	}

	public CursoRepetidoException(Throwable cause) {
		super(cause);
	}

	
}
