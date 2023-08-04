package br.edu.iff.LojaDeAlimentos.controller.view;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.entities.Compra;
import br.edu.iff.LojaDeAlimentos.service.AlimentoService;
import br.edu.iff.LojaDeAlimentos.service.CompraService;

@Controller
@RequestMapping(path = "/compra")

public class CompraController {

	@Autowired
	CompraService compraServ;
	@Autowired
	AlimentoService alimentoServ;

	@GetMapping("/listarCompras")
	@ResponseBody
	public List<Compra> getCompras(@RequestParam Long clienteId) {
		try {
			return compraServ.listarCompras();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	@GetMapping("/alimentosDisponiveis")
	public String listarAlimentosDisponiveis(Model model) {
	    // Aqui você pode adicionar a lógica para buscar os alimentos disponíveis do seu serviço ou repositório
	    // e adicionar essa lista ao modelo para ser utilizada no HTML
	    // Por exemplo:
	    List<Alimento> alimentosDisponiveis = alimentoServ.listarAlimentos();
	    model.addAttribute("alimentos", alimentosDisponiveis);

	    return "alimentos_disponiveis"; // O nome do arquivo HTML que lista os alimentos disponíveis
	}

}
