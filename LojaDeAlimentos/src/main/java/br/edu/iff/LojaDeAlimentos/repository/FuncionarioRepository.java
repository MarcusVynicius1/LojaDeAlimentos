package br.edu.iff.LojaDeAlimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.LojaDeAlimentos.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	@Query(value = "SELECT * FROM FUNCIONARIO", nativeQuery = true)
	List<Funcionario> selectAllFuncionario();
	
}
