package br.com.modulo3.test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import br.com.modulo3.data.dao.ClienteDAO;
import br.com.modulo3.data.dao.PacoteDAO;
import br.com.modulo3.data.dao.PagamentoDAO;
import br.com.modulo3.model.Cliente;
import br.com.modulo3.model.Pacote;
import br.com.modulo3.model.Pagamento;

public class Test {

	public static void main(String[] args) {

		// ClienteDAO clienteDAO = new ClienteDAO();

		// clienteDAO.salvaCliente(new Cliente("Manasséis", "manasseis@email.com"));
		
		/*
		 * clienteDAO.listaClientes(); Cliente cliente = new Cliente("Chris",
		 * "meuemail@email.com"); cliente.setId_cliente(2);
		 * clienteDAO.alteraCliente(cliente);
		 */
		//	 clienteDAO.removeCliente(1);
			 
		/*
		 * Cliente cliente = new Cliente("Chris", "mymail@email.com");
		 * cliente.setId_cliente(2); clienteDAO.alteraCliente(cliente);
		 */
		

	//	PacoteDAO pacoteDAO = new PacoteDAO();

		/*
		 * LocalDateTime dateTime = LocalDateTime.parse("15-07-2000 10:35:10",
		 * DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		 */
		
		//LocalDateTime dateTime = LocalDateTime.of(22, 9, 05, 10, 30, 00);
		
		//  Date dateTime = Calendar.getInstance().getTime();
		  
		//  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		/*
		 * Calendar data_inicio = Calendar.getInstance(); data_inicio.set(2022, 12, 9,
		 * 16, 00, 00); Calendar data_fim = Calendar.getInstance(); data_fim.set(2023,
		 * 01, 1, 13, 00, 00);
		 */
		 
		 // System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		
		
		/*
		 * Pacote pacote = new Pacote(2, "Minas Gerais", data_inicio.getTime(),
		 * data_fim.getTime(), "Meu caminho","eh cada manhan", new BigDecimal(45.5089));
		 */
		 
		 
	//	 pacote.setId(2);
	//	  pacoteDAO.salvaPacote(pacote);
	//	 pacote.setId(1);
    //     pacoteDAO.removePacote(1);
	//	pacoteDAO.alteraPacote(pacote);
	//	pacoteDAO.listaPacotes();
		  
	//	 pacoteDAO.alteraPacote(pacote);
		
		/*
		 * PagamentoDAO pagamentoDAO = new PagamentoDAO();
		 * 
		 * 
		 * pagamentoDAO.salvaPagamento(pagamento);
		 */
		
		/*
		 * PagamentoDAO pagamentoDAO = new PagamentoDAO(); Pagamento pagamento = new
		 * Pagamento(new BigDecimal(750.49), new Date());
		 * 
		 * pagamento.setId_pagamento(11); pagamentoDAO.alteraPagamento(pagamento);
		 */
		 
		 
		
	//	pagamentoDAO.listaPagamentos();
		
	//	pagamentoDAO.removePagamento(1);
		  
		  int escolha;
		  Scanner sc = new Scanner(System.in);
		  
		  System.out.println("**********Base de Dados DevAgens***********");
		  System.out.println("*******Escolha a tabela para gerenciar*****");
		  System.out.println("1 - Cliente | 2 - Pacote | 3 - Pagamento");
		  escolha = Integer.parseInt(sc.nextLine());
		 // sc.close();
		  switch(escolha) {

		     case 1:
		    	 gerenciaClientes();
		    	 break;
		    	 
		     case 2:
		    	 int escolhaPacote;
		    	 System.out.println(" 1 - adicionar pacote | 2 - alterar pacote | 3 - remover pacote | 4 - listar pacotes");
		    	 escolhaPacote = Integer.parseInt(sc.nextLine());
		    	 
		    	 
		     default: System.out.println("Em construcao");
		  }
		  
		

	}
	
	private static void gerenciaClientes() {
		 Scanner sc = new Scanner(System.in);
		 ClienteDAO clienteDAO = new ClienteDAO();
    	 int escolhaCliente;
    	 System.out.println(" 1 - adicionar cliente | 2 - alterar cliente | 3 - remover cliente | 4 - listar clientes");
    	 escolhaCliente = Integer.parseInt(sc.nextLine());
    	
    	 switch(escolhaCliente) {
    	 	case 1:
    	 		Cliente cliente = new Cliente();
    	 		System.out.println("Nome:");
    	 		cliente.setNome(sc.nextLine());
    	 		System.out.println("Email:");
    	 		cliente.setEmail(sc.nextLine());
    	 		
    	 		clienteDAO.salvaCliente(cliente);
    	 		
    	 		break;
    	 		
    	 	case 2:
    	 		Cliente clienteAlterado = new Cliente();
    	 		System.out.println("Nome:");
    	 		clienteAlterado.setNome(sc.nextLine());
    	 		System.out.println("Email:");
    	 		clienteAlterado.setEmail(sc.nextLine());
    	 		clienteDAO.alteraCliente(clienteAlterado);
    	 		break;
    	 		
    	 	case 3:
    	 		int id;
    	 		System.out.println("Informe o id do cliente para exclusao");
    	 		id = Integer.parseInt(sc.nextLine());
    	 		clienteDAO.removeCliente(id);
    	 		break;
    	 		
    	 	case 4:
    	 		clienteDAO.listaClientes();
    	 		break;
    	 		
	 		default: System.out.println("Escolha uma opcao valida.");
    	 		
    	 		
    	 }
	}
}
