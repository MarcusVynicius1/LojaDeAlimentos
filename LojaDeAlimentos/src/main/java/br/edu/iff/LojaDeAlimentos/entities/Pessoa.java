package br.edu.iff.LojaDeAlimentos.entities;

public abstract class Pessoa {

	private String id;
	private String nome;
	private String email;
	private String cpf;
	private String password;

	public Pessoa(String id, String nome, String email, String cpf, String password) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
