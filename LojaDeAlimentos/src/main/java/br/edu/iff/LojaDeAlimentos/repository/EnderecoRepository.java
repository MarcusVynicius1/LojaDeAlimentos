package br.edu.iff.LojaDeAlimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.LojaDeAlimentos.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	@Query(value = "SELECT * FROM ENDERECO", nativeQuery = true)
	List<Endereco> selectAllEndereco();

	
}
