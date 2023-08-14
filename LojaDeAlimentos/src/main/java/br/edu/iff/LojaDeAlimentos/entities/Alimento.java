package br.edu.iff.LojaDeAlimentos.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Alimento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private float preco;
	@Column(nullable = false)
	private String tipoAlimento;
	@OneToMany(mappedBy = "alimento")
	private Collection<Compra> compras;
	
	public Alimento(String nome, float preco, String tipoAlimento) {
		this.nome = nome;
		this.preco = preco;
		this.tipoAlimento = tipoAlimento;
	}
	
	public Alimento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(String tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}

	public Collection<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Collection<Compra> compras) {
		this.compras = compras;
	}
	
}
