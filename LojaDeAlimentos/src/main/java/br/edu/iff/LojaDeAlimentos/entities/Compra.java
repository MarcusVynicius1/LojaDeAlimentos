package br.edu.iff.LojaDeAlimentos.entities;

import java.io.Serializable;
import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIME)
	private Calendar dataHora;
	@Temporal(TemporalType.DATE)
	private Calendar inicio;
	@Temporal(TemporalType.DATE)
	private Calendar termino;
	private int quantidade;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Alimento alimento;

	public Compra(Long id, Calendar dataHora, Calendar inicio, Calendar termino, int quantidade) {
		this.id = id;
		this.dataHora = dataHora;
		this.inicio = inicio;
		this.termino = termino;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public Calendar getInicio() {
		return inicio;
	}

	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public Calendar getTermino() {
		return termino;
	}

	public void setTermino(Calendar termino) {
		this.termino = termino;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
