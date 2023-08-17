package br.edu.iff.LojaDeAlimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.LojaDeAlimentos.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	@Query(value="SELECT * FROM COMPRA WHERE ID = ?1", nativeQuery = true)
	Compra BuscarPeloId(Long id);
	
	@Query(value="SELECT ID_CLIENTE FROM COMPRA WHERE ID = ?1", nativeQuery = true)
	Long BuscarPeloIdCliente(Long id);
	
	@Query(value="SELECT COUNT(*) FROM ASSOCIACAO_COMPRA_ALIMENTO JOIN COMPRA WHERE ID_PRODUTO = ?1 AND ID_COMPRA = ?2", nativeQuery = true)
	int verificarAlimentoCompra(Long idAlimento, Long idCompra);

}
