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
	
	@Query(value="SELECT A.* FROM ALIMENTO A, ASSOCIACAO_COMPRA_ALIMENTO CA WHERE A.ID = CA.ID_ALIMENTO AND CA.ID_COMPRA = ?1", nativeQuery = true)
	List<Alimento> ListarAlimentoPeloIdCompra(Long id);

	List<Alimento> findByTipoAlimento(String tipo);
}