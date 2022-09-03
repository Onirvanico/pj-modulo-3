package br.com.modulo3.model;

public class Cliente {

	private Integer id_cliente;
	private String nome;
	private String email;
	
	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public Cliente() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}
	
	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}
	
}
