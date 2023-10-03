package br.edu.iff.LojaDeAlimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.LojaDeAlimentos.entities.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long>{
	
	@Query(value="SELECT * FROM ALIMENTO WHERE NOME = ?1", nativeQuery = true)
	Alimento buscarPeloNome(String nome);
	
	@Query(value="SELECT * FROM ALIMENTO WHERE ID = ?1", nativeQuery = true)
	Alimento BuscarPeloId(Long id);
	
	@Query(value="SELECT E.* FROM E_BOOK E, ASSOCIACAO_COMPRA_PRODUTO CP WHERE E.ID = CP.FK_PRODUTO AND CP.FK_COMPRA = ?1", nativeQuery = true)
	List<Alimento> ListarAlimentoPeloIdCompra(Long id);


}
