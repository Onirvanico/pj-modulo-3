package br.com.modulo3.model;

import java.math.BigDecimal;
import java.util.Date;


public class Pagamento {

	private int id_pagamento;
	private BigDecimal valor_total;
	private Date data_pagamento;
	private int id_cliente;
	private int id_pacote;
	
	public Pagamento(BigDecimal valor_total, Date data_pagamento, int id_cliente, int id_pacote) {
		
		this.valor_total = valor_total;
		this.data_pagamento = data_pagamento;
		this.id_cliente = id_cliente;
		this.id_pacote = id_pacote;
	}
	
	public Pagamento() {}
	
	public Pagamento(BigDecimal valor_total, Date data_pagamento) {
		this.valor_total = valor_total;
		this.data_pagamento = data_pagamento;
	}
	public void setId_pagamento(int id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_pacote() {
		return id_pacote;
	}

	public void setId_pacote(int id_pacote) {
		this.id_pacote = id_pacote;
	}
	
	public int getId_pagamento() {
		return id_pagamento;
	}
	
}
