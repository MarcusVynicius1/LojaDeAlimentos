package br.edu.iff.LojaDeAlimentos.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alimento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private float preco;
	@Enumerated(EnumType.ORDINAL)
	private TipoAlimento tipoAlimento;
	
	public Alimento(Long id, String nome, float preco, TipoAlimento tipoAlimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.tipoAlimento = tipoAlimento;
	}
	
	
}
