package br.edu.iff.LojaDeAlimentos.entities;

public class Cliente extends Pessoa {

    private float saldoDisponivel;

    public Cliente(String id, String nome, String email, String cpf, String password, float saldoDisponivel) {
        super(id, nome, email, cpf, password);
        this.saldoDisponivel = saldoDisponivel;
    }

    public float getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(float saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }
}
