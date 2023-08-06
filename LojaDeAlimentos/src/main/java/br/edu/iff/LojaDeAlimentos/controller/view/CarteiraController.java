package br.edu.iff.LojaDeAlimentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.LojaDeAlimentos.entities.Carteira;
import br.edu.iff.LojaDeAlimentos.service.CarteiraService;

@Controller
@RequestMapping("/carteira")
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;

    @GetMapping("/adicionar-saldo")
    public String showAdicionarSaldoForm(Model model) {
        model.addAttribute("saldo", 0.0); // Inicializa o saldo como 0.0 na página
        return "adicionarSaldo";
    }

    @PostMapping("/adicionar-saldo")
    public String adicionarSaldo(@RequestParam Long carteiraId, @RequestParam Double valor) {
        Carteira carteira = carteiraService.findById(carteiraId);
        if (carteira != null) {
            carteira.setSaldoDisponivel(valor);
            carteiraService.addCarteira(carteira);
        }
        return "redirect:/carteira/adicionar-saldo"; // Redireciona de volta à página de adicionar saldo
    }
}
