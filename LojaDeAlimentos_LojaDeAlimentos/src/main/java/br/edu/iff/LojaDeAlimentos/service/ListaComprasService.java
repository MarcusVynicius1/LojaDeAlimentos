package br.edu.iff.LojaDeAlimentos.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;
import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.entities.ListaCompras;
import br.edu.iff.LojaDeAlimentos.repository.AlimentoRepository;
import br.edu.iff.LojaDeAlimentos.repository.ClienteRepository;
import br.edu.iff.LojaDeAlimentos.repository.ListaComprasRepository;

@Service
public class ListaComprasService {

	@Autowired
	private ListaComprasRepository listaComprasRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AlimentoRepository alimentoRepository;

	 public void adicionarAlimento(Cliente cliente, Alimento alimento) {
	        ListaCompras listaCompras = listaComprasRepository.findByCliente(cliente);
	        if (listaCompras == null) {
	            listaCompras = new ListaCompras();
	            listaCompras.setCliente(cliente);
	            listaCompras.setAlimentos(new ArrayList<>()); // Inicializa a lista de alimentos
	        }
	        listaCompras.getAlimentos().add(alimento);
	        listaComprasRepository.save(listaCompras);
	    }
}
