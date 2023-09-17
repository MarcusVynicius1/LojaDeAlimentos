package br.edu.iff.LojaDeAlimentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.repository.AlimentoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AlimentoService {

	@Autowired
	AlimentoRepository alimentoRep;

	public String salvarAlimento(Alimento alimento) {
		if (alimentoRep.buscarPeloNome(alimento.getNome()) != null) {
			return "Alimento já cadastrado";
		} else {
			Alimento a = alimentoRep.save(alimento);
			return "Registrado no id " + a.getId();
		}
	}

	public List<Alimento> listarAlimentos() {
		return alimentoRep.findAll();
	}

	public String atualizarAlimento(String nome, double preco, String tipoAlimento) {
		Alimento a = alimentoRep.buscarPeloNome(nome);
		if (a == null) {
			return "Alimento não achado";
		} else {
			if (preco > 0) {
				a.setPreco(preco);
			}
			if (tipoAlimento != null) {
				a.setTipoAlimento(tipoAlimento);
			}
			alimentoRep.flush();
			return "Atualizado no id " + a.getId();
		}
	}

	public String removerAlimento(String nome) {
		Alimento a = alimentoRep.buscarPeloNome(nome);
		if (a != null) {
			alimentoRep.delete(a);
			return "Alimento deletado no id " + a.getId();
		} else {
			return "Alimento não encontrado";
		}
	}

	public Alimento buscarAlimentoPorId(Long id) {
		return alimentoRep.findById(id).orElseThrow(() -> new EntityNotFoundException("Alimento não encontrado"));
	}

	public List<Alimento> listarAlimentosPorIds(List<Long> ids) {
		return alimentoRep.findAllById(ids);
	}

	public List<Alimento> listarAlimentosPorTipo(String tipo) {
		return alimentoRep.findByTipoAlimento(tipo);
	}

	public Alimento getAlimentoByNome(String nome) {
		return alimentoRep.buscarPeloNome(nome);
	}
}
