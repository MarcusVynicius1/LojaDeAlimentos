package br.edu.iff.LojaDeAlimentos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.LojaDeAlimentos.entities.Carteira;
import br.edu.iff.LojaDeAlimentos.repository.CarteiraRepository;

@Service
public class CarteiraService {
	@Autowired
	private CarteiraRepository carteiraRepository;

	public Carteira addCarteira(Carteira carteira) {
		return carteiraRepository.save(carteira);
	}

	public Carteira getCarteiraPorId(Long id) {
		return carteiraRepository.findById(id).orElse(null);
	}

	public List<Carteira> getCarteiras() {
		return carteiraRepository.findAll();
	}

	public void removerCarteira(Long id) {
		carteiraRepository.deleteById(id);
	}
}
