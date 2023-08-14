package br.edu.iff.LojaDeAlimentos.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int quantidade;

    @Column(name = "total")
    private BigDecimal total;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Alimento alimento;

    public Compra() {

    }
    
    public Compra(int quantidade, Cliente cliente, Alimento alimento) {
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.alimento = alimento;
        calcularTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    // Método para calcular e definir o valor total da compra com base no preço unitário do alimento e na quantidade
    public void calcularTotal() {
        if (alimento != null) {
            BigDecimal precoUnitario = BigDecimal.valueOf(alimento.getPreco());
            BigDecimal valorTotal = precoUnitario.multiply(BigDecimal.valueOf(quantidade));
            this.total = valorTotal;
        }
    }
}
