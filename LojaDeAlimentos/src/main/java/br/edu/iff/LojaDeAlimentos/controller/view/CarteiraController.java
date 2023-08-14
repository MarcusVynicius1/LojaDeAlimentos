package br.edu.iff.LojaDeAlimentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.LojaDeAlimentos.entities.Carteira;
import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.entities.Compra;
import br.edu.iff.LojaDeAlimentos.service.CarteiraService;
import br.edu.iff.LojaDeAlimentos.service.ClienteService;

@Controller
@RequestMapping("/carteira")
public class CarteiraController {

    @Autowired
    private CarteiraService carteiraService;
    @Autowired
    private ClienteService clienteServ;

    @GetMapping("/adicionar-saldo")
    public String showAdicionarSaldoForm(Model model) {
        model.addAttribute("carteira", new Carteira()); // Use um objeto Carteira vazio para preencher o formulário
        return "adicionarSaldo";
    }

    @PostMapping("/adicionar-saldo")
    public String adicionarSaldo(@ModelAttribute Carteira carteira, BindingResult result, @RequestParam Double valor) {
        if (result.hasErrors()) {
            return "adicionarSaldo"; // Retorna para a página de adicionar saldo com mensagens de erro
        }

        Carteira carteiraExistente = carteiraService.getCarteiraPorId(carteira.getId());
        if (carteiraExistente == null) {
            return "redirect:/carteira/adicionar-saldo"; // Redireciona para a página de adicionar saldo com mensagem de erro
        }

        carteiraExistente.setSaldoDisponivel(carteiraExistente.getSaldoDisponivel() + valor);
        carteiraService.addCarteira(carteiraExistente);
        return "redirect:/carteira/adicionar-saldo"; // Redireciona para a página de adicionar saldo com mensagem de sucesso
    }

}
