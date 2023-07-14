package br.edu.iff.LojaDeAlimentos.controller.view;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.entities.Endereco;
import br.edu.iff.LojaDeAlimentos.repository.ClienteRepository;
import br.edu.iff.LojaDeAlimentos.repository.EnderecoRepository;

@Controller
@RequestMapping(path = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping
	public String page() {
		return "cliente";
	}

	@PostMapping("/addCliente")
	@ResponseBody
	public String addPessoa(Cliente cliente, @RequestParam String telefones, @RequestParam String rua,
			@RequestParam int numero, @RequestParam String bairro, @RequestParam String cidade,
			@RequestParam String estado, @RequestParam String cep) throws Exception {

		Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);

		Endereco enderecoSalvo = enderecoRepository.save(endereco);

		cliente.setEndereco(enderecoSalvo);

		cliente.setTelefones(Arrays.asList(telefones.split(",")));

		clienteRepository.save(cliente);

		return "Cliente added --> " + cliente.getId();
	}

	@GetMapping("/getCliente")
	@ResponseBody
	public List<Cliente> getClientes() {
		return clienteRepository.selectAllCliente();
	}

}