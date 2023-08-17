package br.edu.iff.LojaDeAlimentos.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public String salvarAlimento(double preco, String nome, String tipoAlimento) {

		return alimentoService.salvarAlimento(new Alimento(preco, nome, tipoAlimento));

	}

	@PutMapping("/{id}")
	public String atualizarE_Book(@PathVariable("id") Long id, double preco, String tipoAlimento) throws Exception {
		Alimento alimentoBusca = alimentoService.buscarAlimentoPorId(id);
		if (alimentoBusca == null) {
			return "Alimento não achado";
		} else {
			return alimentoService.atualizarAlimento(alimentoBusca.getNome(), preco, tipoAlimento);
		}
	}

	@DeleteMapping("/{id}")
	public String removerAlimento(@PathVariable Long id) {
		Alimento alimentoBusca = alimentoService.buscarAlimentoPorId(id);
		if (alimentoBusca == null) {
			return "Alimento não achado";
		} else {
			return alimentoService.removerAlimento(alimentoBusca.getNome());
		}
	}
}
