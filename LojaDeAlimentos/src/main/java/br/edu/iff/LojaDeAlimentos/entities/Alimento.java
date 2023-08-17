package br.edu.iff.LojaDeAlimentos.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Alimento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double preco;
	@Column(unique=true)
	private String nome;
	private String tipoAlimento;

	@ManyToMany(mappedBy="alimento")
	private List<Compra> compra;
	
	public Alimento(double preco, String nome, String tipoAlimento) {
		super();
		this.preco = preco;
		this.nome = nome;
		this.tipoAlimento = tipoAlimento;
	}

	public Alimento() {}
	
	public Long getId() {
		return id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(String tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}
	
	
}
