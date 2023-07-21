package br.edu.iff.LojaDeAlimentos.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.repository.AlimentoRepository;
import br.edu.iff.LojaDeAlimentos.repository.ClienteRepository;
import br.edu.iff.LojaDeAlimentos.service.AlimentoService;
import br.edu.iff.LojaDeAlimentos.service.ListaComprasService;

@Controller
@RequestMapping("/listaCompras")
public class ListaComprasController {

	@Autowired
	private ListaComprasService listaComprasService;
	@Autowired
	AlimentoService alimentoServ;

	 @Autowired
	    private ClienteRepository clienteRepository;

	    @Autowired
	    private AlimentoRepository alimentoRepository;
	
	@PostMapping("/adicionarAlimento")
	@ResponseBody
	 public String adicionarAlimento(@RequestParam Long clienteId, @RequestParam Long alimentoId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        Alimento alimento = alimentoRepository.findById(alimentoId).orElse(null);

        if (cliente == null || alimento == null) {
            return "Cliente ou alimento não encontrado.";
        }

        listaComprasService.adicionarAlimento(cliente, alimento);
        return "Alimento adicionado à lista de compras do cliente.";
    }
}
