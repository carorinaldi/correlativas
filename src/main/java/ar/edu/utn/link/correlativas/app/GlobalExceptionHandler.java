package ar.edu.utn.link.correlativas.app;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MateriaRepetidaException.class)
	@ResponseBody
	public String repetido(MateriaRepetidaException ex) {
		return "la materia " + ex.getMateria().getNombre() + " ya existe....";
	}
	
	@ExceptionHandler(CursoRepetidoException.class)
	@ResponseBody
	public String repetido(CursoRepetidoException ex) {
		return "el curso " + ex.getCurso().getMateria().getNombre() + "-"+ ex.getCurso().getAnio()+" ya existe....";
	}
}
