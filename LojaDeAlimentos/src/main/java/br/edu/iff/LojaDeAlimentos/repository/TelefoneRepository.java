package br.edu.iff.LojaDeAlimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.LojaDeAlimentos.entities.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

}
