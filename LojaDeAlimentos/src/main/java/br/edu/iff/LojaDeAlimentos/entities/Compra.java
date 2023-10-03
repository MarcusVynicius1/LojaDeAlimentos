package br.edu.iff.LojaDeAlimentos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	private int qtdAlimentos;
	private double precoFinal;
	private boolean finalizado;
	private String cpfCliente;
	
	@ManyToMany
	@JoinTable(name = "associacao_compra_alimento",
				joinColumns = @JoinColumn(name = "id_compra"),
				inverseJoinColumns = @JoinColumn(name = "id_alimento"))
	private List<Alimento> alimento;

	public Compra(String cpfCliente) {
		this.finalizado = false;
		this.qtdAlimentos = 0;
		this.alimento = new ArrayList();
		this.cpfCliente = cpfCliente;
	}

	public Compra(Long id, String cpfCliente) {
		this.id = id;
		this.finalizado = false;
		this.qtdAlimentos = 0;
		this.alimento = new ArrayList();
		this.cpfCliente = cpfCliente;
	}
	
	public Compra() {
		
	}

	public Long getId() {
		return id;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public int getQtdAlimentos() {
		return qtdAlimentos;
	}

	public double getPrecoFinal() {
		return precoFinal;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	public void adicionarAlimento(Alimento Alimento) {
		this.alimento.add(Alimento);
		this.qtdAlimentos++;
		this.precoFinal+=Alimento.getPreco();
	}
	
	public void removerAlimento(Alimento Alimento) {
		this.alimento.remove(Alimento);
		this.qtdAlimentos--;
		this.precoFinal-=Alimento.getPreco();
	}
	
	public void finalizar() {
		this.finalizado = true;
		this.dataHora = Calendar.getInstance();
	}
	
	public boolean isFinalizado() {
		return this.finalizado;
	}
}