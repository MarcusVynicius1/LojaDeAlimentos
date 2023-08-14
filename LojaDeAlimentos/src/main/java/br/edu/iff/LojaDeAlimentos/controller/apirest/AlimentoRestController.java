package br.edu.iff.LojaDeAlimentos.controller.apirest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.service.AlimentoService;

@RestController
@RequestMapping("/api/v1/alimentos")
public class AlimentoRestController {

	@Autowired
	private AlimentoService alimentoService;

	@GetMapping
	public List<Alimento> listarAlimentos() {
		return alimentoService.listarAlimentos();
	}

	@GetMapping("/{id}")
	public Alimento buscarAlimentoPorId(@PathVariable Long id) {
		return alimentoService.buscarAlimentoPorId(id);
	}

	@PostMapping
	public Alimento salvarAlimento(@RequestBody Alimento alimento) {
		return alimentoService.salvarAlimento(alimento);
	}

	@PutMapping("/{id}")
	public Alimento atualizarAlimento(@PathVariable Long id, @RequestBody Alimento alimento) {
		alimento.setId(id);
		return alimentoService.atualizarAlimento(alimento);
	}

	@DeleteMapping("/{id}")
	public String removerAlimento(@PathVariable Long id) {
		alimentoService.removerAlimento(id);
		return "Alimento removido";
	}
}
