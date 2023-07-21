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
		return "alimento"; // nome do arquivo HTML que você criou
	}

	@PostMapping("/saveAlimento")
	public String registerAlimento(@ModelAttribute Alimento alimento) {
		alimentoService.salvarAlimento(alimento);
		return "redirect:/alimento/listar"; // redireciona para a página do formulário com uma mensagem de
														// sucesso
	}
	
	@GetMapping("/listar")
	public String listarAlimentos(Model model) {
	    List<Alimento> alimentos = alimentoService.listarAlimentos();
	    model.addAttribute("alimentos", alimentos);
	    return "listaAlimentos"; // Nome do arquivo HTML que exibirá a lista de alimentos
	}
	@GetMapping("/editar")
	public String editarAlimento(@RequestParam Long id, Model model) {
	    Alimento alimento = alimentoService.buscarAlimentoPorId(id);
	    model.addAttribute("alimento", alimento);
	    return "editarAlimento"; // Nome do arquivo HTML com o formulário de edição do alimento
	}

	@PostMapping("/atualizar")
	public String atualizarAlimento(@ModelAttribute Alimento alimento) {
	    alimentoService.atualizarAlimento(alimento);
	    return "redirect:/alimento/listar"; // Redireciona para a página que lista os alimentos após atualizar
	}
	
	@GetMapping("/excluir")
	public String excluirAlimento(@RequestParam Long id) {
	    alimentoService.removerAlimento(id);
	    return "redirect:/alimento/listar"; // Redireciona para a página que lista os alimentos após excluir
	}


}
