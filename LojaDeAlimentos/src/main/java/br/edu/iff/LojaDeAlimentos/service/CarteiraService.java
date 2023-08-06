package br.edu.iff.LojaDeAlimentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iff.LojaDeAlimentos.entities.Carteira;
import br.edu.iff.LojaDeAlimentos.repository.CarteiraRepository;

@Service
public class CarteiraService {

    @Autowired
    private CarteiraRepository carteiraRepository;

    public Carteira findById(Long id) {
        return carteiraRepository.findById(id).orElse(null);
    }

    @Transactional
    public Carteira addCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }
}
