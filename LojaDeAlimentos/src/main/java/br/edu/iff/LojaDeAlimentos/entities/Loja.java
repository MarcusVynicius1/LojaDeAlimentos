package br.edu.iff.LojaDeAlimentos.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Loja implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private static final String nome = "Loja De Alimentos";
	@Column(nullable = false)
	private static final String cnpj = "62.958.432/0001-13";
	@OneToOne
	private static final Endereco endereco = new Endereco("Rua das pedras", 24, "Parque Palmeiras",
			"Campos dos Goytacazes", "RJ", "28180-932");
	@ElementCollection
	@OneToMany
	private Collection<Alimento> alimento;

	public Loja() {
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public static String getNome() {
		return nome;
	}

	public static String getCnpj() {
		return cnpj;
	}

	public static Endereco getEndereco() {
		return endereco;
	}

}
