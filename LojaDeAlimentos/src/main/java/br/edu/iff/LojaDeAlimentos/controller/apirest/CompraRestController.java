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

import br.edu.iff.LojaDeAlimentos.entities.Compra;
import br.edu.iff.LojaDeAlimentos.service.CompraService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/compra")
public class CompraRestController {

	@Autowired
	private CompraService compraServ;

	@PostMapping
	public String adicionarAlimento(@RequestBody Compra compra) {
		compraServ.salvarCompra(compra);
		return "compra efetuada com sucesso";
	}

	@GetMapping
	public List<Compra> listarCompras() {
		return compraServ.listarCompras();
	}

	@GetMapping("/{id}")
	public Compra buscarCompraPorId(@PathVariable Long id) {
		return compraServ.buscarPeloID(id);
	}

	@PutMapping("/{id}")
	public String atualizarCompra(@PathVariable Long id, @RequestBody Compra compra) {
		compra.setId(id);
		compraServ.salvarCompra(compra);
		return "Compra atualizada com sucesso";
	}

	@DeleteMapping("/{id}")
	public String deletarCompra(@PathVariable Long id) {
		compraServ.removerCompra(id);
		return "Compra deletada com sucesso";
	}

}
