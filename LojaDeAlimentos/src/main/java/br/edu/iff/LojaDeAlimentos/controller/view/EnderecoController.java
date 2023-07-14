package br.edu.iff.LojaDeAlimentos.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.LojaDeAlimentos.entities.Endereco;
import br.edu.iff.LojaDeAlimentos.repository.EnderecoRepository;

@Controller
public class EnderecoController {

	@Autowired
	private EnderecoRepository res;

	@PostMapping("/addEndereco")
	@ResponseBody
	public String addPessoa(Endereco endereco) throws Exception {
		Endereco e = res.save(endereco);
		return "Endereco add --> " + e.enderecoFormatado();

	}

	@GetMapping("/getEndereco")
	@ResponseBody
	public List<Endereco> getEndereco() {
		return res.selectAllEndereco();
	}

}
