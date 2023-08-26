package br.edu.iff.LojaDeAlimentos.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.entities.Compra;
import br.edu.iff.LojaDeAlimentos.service.CompraService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/v1/compra")
public class CompraRestController {

	@Autowired
	private CompraService compraServ;

	@PostMapping
	public String addCompra(Long id, String cpf) {

		return compraServ.addCompraAPI(id, cpf);

	}

	@GetMapping
	public List<Compra> listarCompras() {
		return compraServ.listarCompras();
	}

	@GetMapping("/{id}")
	public Compra buscarCompraPorId(@PathVariable Long id) {
		return compraServ.getCompraById(id);
	}

	@PutMapping("/{id}")
	public String atualizarCompra(@PathVariable("id") String id, String cpf) throws Exception {
		return compraServ.atualizarCompra(id, cpf);
	}

	@DeleteMapping("/{id}")
	public String deletarCompra(@PathVariable("id") Long id, String nome) throws Exception {
		return compraServ.removeAlimento(id, nome);
	}

	@PatchMapping("/{id}")
	@ResponseBody
	public String finalizarCompra(@PathVariable("id") Long id) throws Exception {
		return compraServ.finalizarCompraPeloId(id);
	}

	@PostMapping("/{id}/alimento")
	@ResponseBody
	@Operation(summary = "Adicionar um alimento em uma compra em expecifíco")
	public String addAlimento(@PathVariable("id") String id, String titulo) throws Exception {
		return compraServ.addAlimento(id, titulo);
	}

	@GetMapping("/{id}/alimento")
	@ResponseBody
	@Operation(summary = "Listar os alimentos de uma compra em expecifíco")
	public List<Alimento> listarAlimentos(@PathVariable("id") Long id) throws Exception {
		return compraServ.ListarAlimentoPeloIdCompra(id);
	}

	@DeleteMapping("/{id}/alimento")
	@ResponseBody
	@Operation(summary = "Deletar um alimento em uma compra em expecifíco")
	public String removeAlimentok(@PathVariable("id") Long id, String nome) throws Exception {
		return compraServ.removeAlimento(id, nome);
	}

}