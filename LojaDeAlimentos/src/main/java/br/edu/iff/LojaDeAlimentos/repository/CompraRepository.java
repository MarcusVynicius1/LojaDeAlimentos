package br.edu.iff.LojaDeAlimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.LojaDeAlimentos.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	@Query(value = "SELECT * FROM COMPRA WHERE ID = ?1", nativeQuery = true)
	Compra BuscarPeloId(Long id);

	@Query(value = "SELECT ID_CLIENTE FROM COMPRA WHERE ID = ?1", nativeQuery = true)
	Long BuscarPeloIdCliente(Long id);

}
