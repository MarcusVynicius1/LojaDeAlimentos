package br.edu.iff.LojaDeAlimentos.entities;

import java.util.Collection;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente extends Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	@OneToOne
	@JoinColumn(name = "id_carteira")
	private Carteira carteira;
	@ElementCollection
	private Collection<String> telefones;
	@OneToMany(mappedBy = "cliente")
	private Collection<Compra> compras;

	public Cliente(String nome, String email, String cpf, String password, Endereco endereco, Carteira carteira,
			String telefones) {
		super(nome, email, cpf, password);
		this.endereco = endereco;
		this.carteira = carteira;
		this.telefones.add(telefones);
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

	public Collection<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones.add(telefones);
	}
}
