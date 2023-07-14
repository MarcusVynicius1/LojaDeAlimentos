package br.edu.iff.LojaDeAlimentos.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;

@Controller
@RequestMapping(path = "/alimento")
public class AlimentoController {

    @GetMapping("/cadastro")
    public String showCadastroAlimentoForm() {
        return "alimento";
    }
	
	@PostMapping("/saveAlimento")
	public String registerAlimento(@ModelAttribute Alimento alimento) {
		System.out.println("ID do alimento: " + alimento.getId());
		System.out.println("Nome do alimento: " + alimento.getNome());
		System.out.println("Preco do alimento: " + alimento.getPreco());
		System.out.println("Tipo de alimento: " + alimento.getTipoAlimento());
		return "sucesso";
	}

}
