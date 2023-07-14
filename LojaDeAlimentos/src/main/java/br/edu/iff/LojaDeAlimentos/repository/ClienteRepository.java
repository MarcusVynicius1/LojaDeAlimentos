package br.edu.iff.LojaDeAlimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.LojaDeAlimentos.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value = "SELECT * FROM CLIENTE", nativeQuery = true)
	List<Cliente> selectAllCliente();

}
