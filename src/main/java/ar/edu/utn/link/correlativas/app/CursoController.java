package ar.edu.utn.link.correlativas.app;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.correlativas.model.Curso;

//@RestController
//@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private RepoCursoMem repo;
	
	@GetMapping("")
	public Collection<Curso> list(@RequestParam(value="anio", required=false) Integer anio) {
		
		if(anio == null) {
			//System.out.println(page);
			return repo.all();
		} else {
		return repo.findByYear(anio);
		}
	}
	
	@GetMapping("/{nombre}")
	public Curso get(@PathVariable("nombre") String nombreCurso) {
		return repo.findByName(nombreCurso);
	}
	
	@PostMapping("") 
	public String post(@RequestBody Curso curso) throws CursoRepetidoException {

		repo.save(curso);
		return "ok";
	
	}
	
	
}
