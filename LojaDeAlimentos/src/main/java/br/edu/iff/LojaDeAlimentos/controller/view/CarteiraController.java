package br.edu.iff.LojaDeAlimentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.LojaDeAlimentos.entities.Carteira;
import br.edu.iff.LojaDeAlimentos.repository.CarteiraRepository;

@Controller
@RequestMapping("/carteira")
public class CarteiraController {

    @Autowired
    private CarteiraRepository carteiraRepository;

    @GetMapping("/")
    public String exibirSaldo(Model model) {
        Carteira carteira = carteiraRepository.findById(1L).orElse(null);
        if (carteira != null) {
            double saldo = carteira.getSaldoDisponivel();
            model.addAttribute("saldo", saldo);
        }
        return "exibir-saldo";
    }

    @PostMapping("/adicionar-saldo")
    public String adicionarSaldo(double valor) {
        Carteira carteira = carteiraRepository.findById(1L).orElse(null);
        if (carteira != null) {
            double saldoAtual = carteira.getSaldoDisponivel();
            carteira.setSaldoDisponivel(saldoAtual + valor);
            carteiraRepository.save(carteira);
        }
        return "redirect:/carteira/";
    }


}
