package br.edu.iff.LojaDeAlimentos.entities;

import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

	public Funcionario(String id, String nome, String email, String cpf, String password) {
		 super(id, nome, email, cpf);
	}

}
