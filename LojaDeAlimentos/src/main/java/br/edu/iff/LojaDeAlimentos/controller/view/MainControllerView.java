package br.edu.iff.LojaDeAlimentos.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.LojaDeAlimentos.entities.Cliente;

@Controller
@RequestMapping(path = "/home")
public class MainControllerView {

	@GetMapping()
	public String page() {
		return "index";
	}
	
	@PostMapping("/savePessoa")
	public String registerPessoa(@ModelAttribute Cliente cliente) {
		System.out.println("ID da pessoa: " + cliente.getId());
		System.out.println("Nome da pessoa: " + cliente.getNome());
		System.out.println("Email da pessoa: " + cliente.getEmail());
		System.out.println("CPF da pessoa: " + cliente.getCpf());
		return "sucesso";
	}
	
}
