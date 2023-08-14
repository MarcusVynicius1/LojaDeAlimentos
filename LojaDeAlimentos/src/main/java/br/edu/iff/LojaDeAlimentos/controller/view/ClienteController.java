package br.edu.iff.LojaDeAlimentos.controller.view;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.LojaDeAlimentos.entities.Carteira;
import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.entities.Endereco;
import br.edu.iff.LojaDeAlimentos.service.CarteiraService;
import br.edu.iff.LojaDeAlimentos.service.ClienteService;
import br.edu.iff.LojaDeAlimentos.service.EnderecoService;
import jakarta.persistence.EntityNotFoundException;

@Controller
@RequestMapping(path = "/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteServ;
	@Autowired
	EnderecoService enderecoServ;
	@Autowired
	CarteiraService carteiraServ;

	@GetMapping
	public String page() {
		return "cliente";
	}

	@GetMapping("/crud")
	public String page2(Model model) {
		List<Cliente> clientes = clienteServ.findAll();
		model.addAttribute("clientes", clientes);
		return "listarClientes"; // nome do arquivo HTML que você criou para listar os clientes
	}

	@PostMapping("/addCliente")
	@ResponseBody
	public String addPessoa(Cliente cliente, @RequestParam String telefones, @RequestParam String rua,
			@RequestParam int numero, @RequestParam String bairro, @RequestParam String cidade,
			@RequestParam String estado, @RequestParam String cep) throws Exception {

		Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);

		Endereco enderecoSalvo = enderecoServ.addEndereco(endereco);

		Carteira carteira = new Carteira(0);

		Carteira carteiraSalva = carteiraServ.addCarteira(carteira);

		cliente.setCarteira(carteiraSalva);

		cliente.setEndereco(enderecoSalvo);

		cliente.setTelefones(Arrays.asList(telefones.split(",")));

		clienteServ.addCliente(cliente);

		return "sucesso";
	}

	@GetMapping("/getCliente")
	@ResponseBody
	public List<Cliente> getClientes() {
		return clienteServ.findAll();
	}

	@GetMapping("/getAllCliente")
	@ResponseBody
	public List<String> getAllClientes() {
		return clienteServ.selectAllInfoCliente();
	}

	@GetMapping("/getClienteId")
	@ResponseBody
	public ResponseEntity<Cliente> getCliente(@RequestParam Long id) {
		try {
			Cliente cliente = clienteServ.findById(id);
			return ResponseEntity.ok(cliente);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build(); // Retorna status 404 - Not Found
		}
	}

	@GetMapping("/alterar")
	public String showAlterarClienteForm(@RequestParam Long id, Model model) {
		Cliente cliente = clienteServ.findById(id);
		if (cliente != null) {
			model.addAttribute("cliente", cliente);
			return "alterarCliente";
		} else {
			return "clienteNaoEncontrado";
		}
	}

	@PostMapping("/updateCliente")
	@ResponseBody
	public String updateCliente(@RequestParam Long id, @ModelAttribute Cliente clienteAtualizado,
			@RequestParam(required = false) Double novoSaldo) {
		Cliente cliente = clienteServ.findById(id);
		if (cliente != null) {
			cliente.setNome(clienteAtualizado.getNome());
			cliente.setEmail(clienteAtualizado.getEmail());
			cliente.setPassword(clienteAtualizado.getPassword());
			cliente.setCpf(clienteAtualizado.getCpf());
			Carteira carteira = cliente.getCarteira();
			double saldoAtual = carteira.getSaldoDisponivel();
			carteira.setSaldoDisponivel(saldoAtual + novoSaldo);
			carteiraServ.addCarteira(carteira);
			clienteServ.addCliente(cliente);
			return "sucesso";
		} else {
			return "Cliente não encontrado";
		}
	}

	@PostMapping("/deleteCliente")
	@ResponseBody
	public String deleteCliente(@RequestParam Long id) {
		Cliente cliente = clienteServ.findById(id);
		if (cliente != null) {
			clienteServ.deleteCliente(cliente);
			return "sucesso";
		} else {
			return "Cliente não encontrado";
		}
	}
}