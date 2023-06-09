package br.edu.iff.LojaDeAlimentos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente extends Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Endereco endereco;
	private Carteira carteira;

	public Cliente(String nome, String email, String cpf, String password) {
		super(nome, email, cpf, password);
		this.carteira = new Carteira(0);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}
}
