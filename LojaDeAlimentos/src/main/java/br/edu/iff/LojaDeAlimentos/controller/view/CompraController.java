package br.edu.iff.LojaDeAlimentos.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.entities.Compra;
import br.edu.iff.LojaDeAlimentos.repository.CompraRepository;
import br.edu.iff.LojaDeAlimentos.service.AlimentoService;
import br.edu.iff.LojaDeAlimentos.service.ClienteService;
import br.edu.iff.LojaDeAlimentos.service.CompraService;

@Controller
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService compraService;
	@Autowired
	private AlimentoService alimentoService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CompraRepository compraRep;

	@GetMapping()
	public String listarCompras(Model model) {
		model.addAttribute("compras", compraService.listarCompras());
		return "listarCompras";
	}

	@GetMapping("/{id}")
	public String visualizarCompra(@PathVariable Long id, Model model) {
		Compra compra = compraService.getCompraById(id);
		List<Alimento> alimentos = alimentoService.listarAlimentos();
		if (compra == null) {
			return "redirect:/compra";
		}
		Cliente cliente = compraService.getClienteDaCompra(id);
		if (cliente != null) {
			model.addAttribute("saldoCliente", cliente.verSaldo());
		}
		model.addAttribute("alimentos", alimentos);
		model.addAttribute("compra", compra);
		return "teste";
	}

	@GetMapping("/criar")
	public String exibirFormularioCriacaoCompra(Model model) {
		model.addAttribute("compra", new Compra());
		return "formularioCriacaoCompra";
	}

	@PostMapping("/criar")
	public String criarCompra(Compra compra) {
		String cpfCliente = compra.getCpfCliente();
		String resultado = compraService.addCompra(cpfCliente);
		return "redirect:/compra";
	}
	

	@PostMapping("atualizar/{id}")
	public String atualizarCompra(@PathVariable("id") String id, String cpf) throws Exception {
		return compraService.atualizarCompra(id, cpf);
	}

	

	@GetMapping("/{id}/adicionarAlimento")
	public String exibirFormularioAdicaoAlimento(@PathVariable Long id, Model model) {
		model.addAttribute("compraId", id);
		return "formularioAdicaoAlimento";
	}

	@PostMapping("/{id}/adicionarAlimento")
	public String adicionarAlimentoACompra(@PathVariable Long id, String nomeAlimento) {
		Compra compra = compraService.getCompraById(id);
		if (compra != null) {
			Alimento alimento = alimentoService.getAlimentoByNome(nomeAlimento);
			if (alimento != null) {
				compra.adicionarAlimento(alimento);
				compraRep.save(compra);
			}
		}
		return "redirect:/compra/" + id;
	}

	@PostMapping("/deletarAlimento")
	public String deletarAlimentoDaCompra(@RequestParam Long idCompra, @RequestParam String nomeAlimento) throws Exception {
		return compraService.removeAlimento(idCompra, nomeAlimento);
	}
	
	@PostMapping("/{id}/finalizar")
	public String finalizarCompra(@PathVariable Long id) {
		String resultado = compraService.finalizarCompraPeloId(id);
		return "redirect:/compra/" + id;
	}

	@GetMapping("/carrinho/{id}")
	public String verCarrinho(@PathVariable("id") Long id, Model model) {
		Cliente cliente = compraService.getClienteDaCompra(id);
		if (cliente != null) {
			model.addAttribute("saldoCliente", cliente.verSaldo());
		}
		Compra compra = compraService.getCompraById(id);		
		List<Alimento> alimentos = compraService.ListarAlimentoPeloIdCompra(id);	
		model.addAttribute("alimentos", alimentos);
		model.addAttribute("compra", compra);
		return "carrinho";

	}

}