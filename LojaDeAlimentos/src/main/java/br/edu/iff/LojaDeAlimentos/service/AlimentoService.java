package br.edu.iff.LojaDeAlimentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.repository.AlimentoRepository;

@Service
public class AlimentoService {

	@Autowired
	AlimentoRepository alimentoRep;

	public Alimento salvarAlimento(Alimento alimento) {
		return alimentoRep.save(alimento);
	}

	public List<Alimento> listarAlimentos() {
		return alimentoRep.findAll();
	}

	public Alimento atualizarAlimento(Alimento alimento) {
		if (alimento.getId() != null) {
			return alimentoRep.save(alimento);
		} else {
			throw new RuntimeException("Alimento inexistente. Primeiro adicione o alimento.");
		}
	}

	public void removerAlimento(Long alimentoId) {
		alimentoRep.deleteById(alimentoId);
	}
	
	public Alimento buscarAlimentoPorId(Long id) {
        return alimentoRep.findById(id).orElse(null);
    }

}
