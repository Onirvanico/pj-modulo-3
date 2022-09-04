package br.com.modulo3.model;

import java.math.BigDecimal;
import java.util.Date;

public class Pacote {
	
	private int id_pacote;
	private int num_viajantes;
	private String destino;
	private Date data_inicio;
	private String titulo;
	private String descricao;
	private Date data_fim;
	private BigDecimal preco;
	
	public Pacote(int num_viajantes, String destino, Date data_inicio,
			Date data_fim, String titulo, String descricao, 
			BigDecimal preco) {
		
		this.num_viajantes = num_viajantes;
		this.destino = destino;
		this.data_inicio = data_inicio;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data_fim = data_fim;
		this.preco = preco;
	}
	
	public Pacote( ) {}
	
	
	public int getNum_viajantes() {
		return num_viajantes;
	}

	public void setNum_viajantes(int num_viajantes) {
		this.num_viajantes = num_viajantes;
	}
	
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public int getId_pacote() {
		return id_pacote;
	}

	public void setId(int id) {
		this.id_pacote = id;
		
	}
}
