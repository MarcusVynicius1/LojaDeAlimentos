package br.edu.iff.LojaDeAlimentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.entities.Compra;
import br.edu.iff.LojaDeAlimentos.repository.CompraRepository;
import br.edu.iff.LojaDeAlimentos.service.AlimentoService;
import br.edu.iff.LojaDeAlimentos.service.CompraService;

@Controller
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;
    @Autowired
    private AlimentoService alimentoService;
    @Autowired
    private CompraRepository compraRep;

    @GetMapping()
    public String listarCompras(Model model) {
        model.addAttribute("compras", compraService.listarCompras());
        return "listarCompras";
    }

    @GetMapping("/{id}")
    public String visualizarCompra(@PathVariable Long id, Model model) {
        Compra compra = compraService.getCompraById(id);
        if (compra == null) {
            return "redirect:/compra"; 
        }
        model.addAttribute("compra", compra);
        return "visualizarCompra";
    }

    @GetMapping("/criar")
    public String exibirFormularioCriacaoCompra(Model model) {
        model.addAttribute("compra", new Compra());
        return "formularioCriacaoCompra";
    }

    @PostMapping("/criar")
    public String criarCompra(Compra compra) {
        String cpfCliente = compra.getCpfCliente();
        String resultado = compraService.addCompra(cpfCliente);
        return "redirect:/compra"; 
    }
    
    @GetMapping("/{id}/adicionarAlimento")
    public String exibirFormularioAdicaoAlimento(@PathVariable Long id, Model model) {
        model.addAttribute("compraId", id);
        return "formularioAdicaoAlimento"; 
    }

    @PostMapping("/{id}/adicionarAlimento")
    public String adicionarAlimentoACompra(@PathVariable Long id, String nomeAlimento) {
        Compra compra = compraService.getCompraById(id);
        if (compra != null) {
            Alimento alimento = alimentoService.getAlimentoByNome(nomeAlimento);
            if (alimento != null) {
                compra.adicionarAlimento(alimento);
                compraRep.save(compra);
            }
        }
        return "redirect:/compra/" + id;
    }

    @PostMapping("/{id}/finalizar")
    public String finalizarCompra(@PathVariable Long id) {
        String resultado = compraService.finalizarCompraPeloId(id);
        return "redirect:/compra/" + id;
    }


}
