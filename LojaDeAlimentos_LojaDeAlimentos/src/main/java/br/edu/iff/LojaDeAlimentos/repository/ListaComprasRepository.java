package br.edu.iff.LojaDeAlimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.LojaDeAlimentos.entities.Cliente;
import br.edu.iff.LojaDeAlimentos.entities.ListaCompras;

@Repository
public interface ListaComprasRepository extends JpaRepository<ListaCompras, Long> {
	ListaCompras findByCliente(Cliente cliente);
}
