	package br.edu.iff.LojaDeAlimentos.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.service.AlimentoService;

@Controller
@RequestMapping("/alimento")
public class AlimentoController {

	@Autowired
	private AlimentoService alimentoService;

	@GetMapping("/cadastro")
	public String showCadastroAlimentoForm(Model model) {
		model.addAttribute("alimento", new Alimento());
		return "alimento";
	}

	@PostMapping("/saveAlimento")
	public String registerAlimento(@ModelAttribute Alimento alimento) {
		alimentoService.salvarAlimento(alimento);
		return "redirect:/alimento/listar";
											
	}

	@GetMapping("/listar")
	public String listarAlimentos(Model model) {
		List<Alimento> alimentos = alimentoService.listarAlimentos();
		model.addAttribute("alimentos", alimentos);
		return "listaAlimentos";
	}

	@GetMapping("/editar")
	public String editarAlimento(@RequestParam Long id, Model model) {
		Alimento alimento = alimentoService.buscarAlimentoPorId(id);
		model.addAttribute("alimento", alimento);
		return "editarAlimento";
	}

	@PostMapping("/atualizar")
	public String atualizarAlimento(@RequestParam String nome, double preco, String tipoALimento) {
		alimentoService.atualizarAlimento(nome, preco, tipoALimento);
		return "redirect:/alimento/listar";
	}

	@GetMapping("/excluir")
	public String excluirAlimento(@RequestParam String nome) {
		alimentoService.removerAlimento(nome);
		return "redirect:/alimento/listar";
	}

}
