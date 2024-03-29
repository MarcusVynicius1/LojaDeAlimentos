package br.edu.iff.LojaDeAlimentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.LojaDeAlimentos.entities.Endereco;
import br.edu.iff.LojaDeAlimentos.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository res;

	public Endereco addEndereco(Endereco endereco) {
		return res.save(endereco);
	}

	public List<Endereco> getEndereco() {
		return res.selectAllEndereco();
	}

	public Endereco getEnderecoPorId(Long id) {
		return res.findById(id).orElse(null);
	}

	public void removerEndereco(Long id) {
		res.deleteById(id);
	}

}
