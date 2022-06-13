package ar.edu.utn.link.correlativas.app;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.link.correlativas.model.Materia;

@RestController
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	@Qualifier("jpa2")
	private RepoMateria repo;

	@Value("${algo}")
	private Integer correlativaMax;

	@Value("${loco:hola}")
	private String desc;

	@GetMapping("")
	public Page<Materia> list(@RequestParam(value = "anio", required = false) Integer anio, Pageable page) {

		if (anio == null) {
			return repo.findAll(page);
		} else {
			return repo.findByAnio(anio, page);
		}

	}

	@GetMapping("/{nombre}")
	public Materia get(@PathVariable("nombre") String nombreMateria) {
		return repo.findByNombre(nombreMateria);
	}

	@Transactional
	@PostMapping("")
	public String post(@RequestBody @Valid Materia materia, BindingResult bindingResult)
			throws MateriaRepetidaException {
		if (!bindingResult.hasErrors()) {
			repo.save(materia);
			return "ok";
		} else {
			bindingResult.getFieldErrors().stream().forEach(x -> {
				System.out.print(x.getField());
				x.getDefaultMessage();
			});
			return "no ok, con errores";
		}

	}

}

//@Valid para validar los parametros y q no esten en blanco -- @BindingResult
// para volver a tener el control del resultado y que no le muestre el trace al
// usuario (para volver a controlar los errores)
