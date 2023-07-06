package br.edu.iff.LojaDeAlimentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.entities.Pessoa;
import br.edu.iff.LojaDeAlimentos.repository.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository res;
	
	@PostMapping("/")
	public String addPessoa(Cliente cliente) throws Exception {
		Pessoa c = res.save(cliente);
		return "Cliente added -->"+c.getId()+"-->";
	}
	
}