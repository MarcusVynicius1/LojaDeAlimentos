package br.edu.iff.LojaDeAlimentos.entities;

import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

	public Funcionario(String nome, String email, String cpf, String password) {
		super(nome, email, cpf, password);
	}

	public Funcionario() {
		
	}
	
}
