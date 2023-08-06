package br.edu.iff.LojaDeAlimentos.controller.apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.LojaDeAlimentos.entities.Funcionario;
import br.edu.iff.LojaDeAlimentos.service.FuncionarioService;

@RestController
@RequestMapping(path = "/api/v1/funcionario")
public class FuncionarioRestController {
	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping("/adicionar")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.addFuncionario(funcionario);
		return funcionario;
	}


	@PutMapping("/atualizar")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Funcionario updateFuncionario(@RequestBody Funcionario funcionario) {		
		Funcionario func = funcionarioService.updateFuncionario(funcionario);
	    return func;
	}

	@DeleteMapping("/deletar/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String deletarFuncionario(@PathVariable("id") Long id) throws Exception {
	    Funcionario fBusca = funcionarioService.findById(id);
	    if (fBusca == null) {
	        return "Funcionario não encontrado";
	    } else {
	        funcionarioService.deleteFuncionario(id);
	        return "funcionário excluído";
	    }
	}

	@GetMapping("")
	public List<Funcionario> listarFuncionarios() throws Exception {
		return funcionarioService.findAll();
	}

	@GetMapping("/buscar/{id}")
	public Funcionario buscarFuncionarioId(@PathVariable("id") Long id) throws Exception {
		return funcionarioService.findById(id);
	}

}
