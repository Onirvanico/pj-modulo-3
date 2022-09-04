package br.com.modulo3.test;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

import br.com.modulo3.data.dao.ClienteDAO;
import br.com.modulo3.data.dao.PacoteDAO;
import br.com.modulo3.data.dao.PagamentoDAO;
import br.com.modulo3.model.Cliente;
import br.com.modulo3.model.Pacote;
import br.com.modulo3.model.Pagamento;
import utils.DateUtil;

public class Test {

	public static void main(String[] args) {

		// ClienteDAO clienteDAO = new ClienteDAO();

		// clienteDAO.salvaCliente(new Cliente("Manass�is", "manasseis@email.com"));
		
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
		  
		  do {
			  System.out.println("\n1 - Cliente | 2 - Pacote | 3 - Pagamento | 4 - Finalizar\n");
			  escolha = Integer.parseInt(sc.nextLine());
			  
			  switch(escolha) {
			  
			  case 1:
				  gerenciaClientes(sc);
				  break;
				  
			  case 2:
				  gerenciaPacotes(sc);
				  break;
				  
			  case 3:
				  gerenciaPagamentos(sc);
				  break;
				
			  case 4:
				  System.out.println("Programa finalizado com sucesso");
				  break;
			  
			  default: System.out.println("\nOpcao invalida");
			  
			  }
			  
			  
		  } while(escolha != 4);

	}
	
	private static void gerenciaClientes(Scanner sc) {
		 ClienteDAO clienteDAO = new ClienteDAO();
    	 int escolhaCliente;
    	 System.out.println("\n1 - adicionar cliente | 2 - alterar cliente | 3 - remover cliente | 4 - listar clientes\n");
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
    	 		System.out.println("Id do cliente:");
    	 		clienteAlterado.setId_cliente(Integer.parseInt(sc.nextLine()));
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
	
	private static void gerenciaPacotes(Scanner sc) {
		 int escolhaPacote;
		  PacoteDAO pacoteDAO = new PacoteDAO();
		  System.out.println("\n 1 - adicionar pacote | 2 - alterar pacote | 3 - remover pacote | 4 - listar pacotes\n");
		  escolhaPacote = Integer.parseInt(sc.nextLine());
		  switch(escolhaPacote) {
		  	case 1:
		  		Pacote pacote = preenchePacote(sc);
		  		pacoteDAO.salvaPacote(pacote);
		  		break;
	  		
		  	case 2:
		  		Pacote pacoteAlterado = preenchePacote(sc);
		  		System.out.println("Id do pacote:");
		  		pacoteAlterado.setId(Integer.parseInt(sc.nextLine()));
		  	    pacoteDAO.alteraPacote(pacoteAlterado);
		  		break;
		  		
		  	case 3:
		  		System.out.println("Id do pacote a ser excluido:");
		  		int id = Integer.parseInt(sc.nextLine());
		  		pacoteDAO.removePacote(id);
		  		break;
		  		
		  	case 4:
		  		pacoteDAO.listaPacotes();
		  		break;
	  		
		  	default: System.out.println("Opcao invalida.");
		  }
	}
	
	private static Pacote preenchePacote(Scanner sc) {
		Pacote pacote = new Pacote();
  		System.out.println("Informe uma data de inicio no formato d/MM/aaaa:");
  		Date data_inicio = DateUtil.stringToDate(sc.nextLine());
  		pacote.setData_inicio(data_inicio);
  		System.out.println("Informe uma data de fim no formato d/MM/aaaa:");
  		pacote.setData_fim(DateUtil.stringToDate(sc.nextLine()));
  		System.out.println("Descricao para o pacote:");
  		pacote.setDescricao(sc.nextLine());
  		System.out.println("Destino do pacote:");
  		pacote.setDestino(sc.nextLine());
  		System.out.println("Total de viajantes:");
  		pacote.setNum_viajantes(Integer.parseInt(sc.nextLine()));
  		System.out.println("Defina um titulo para o pacote:");
  		pacote.setTitulo(sc.nextLine());
  		System.out.println("Preco:");
  		pacote.setPreco(sc.nextBigDecimal());
  		sc.nextLine();
  		
  		return pacote;
	}
	
	private static void gerenciaPagamentos(Scanner sc) {
		
		 PagamentoDAO pagamentoDAO = new PagamentoDAO();
		  int escolhaPagamento;
		  System.out.println("\n 1 - adicionar pagamento | 2 - alterar pagamento | 3 - remover pagamento | 4 - listar pagamentos\n");
		  escolhaPagamento = Integer.parseInt(sc.nextLine());
		  switch(escolhaPagamento) {
		  
		  	case 1:
		  		Pagamento pagamento = new Pagamento();
		  		System.out.println("Informe data do pagamento no formato d/MM/aaaa:");
		  		pagamento.setData_pagamento(DateUtil.stringToDate(sc.nextLine()));
		  		System.out.println("Id do cliente:");
		  		pagamento.setId_cliente(Integer.parseInt(sc.nextLine()));
		  		System.out.println("Id do pacote:");
		  		pagamento.setId_pacote(Integer.parseInt(sc.nextLine()));
		  		System.out.println("Valor total");
		  		pagamento.setValor_total(new BigDecimal(Integer.parseInt(sc.nextLine())));
		  		
		  		pagamentoDAO.salvaPagamento(pagamento);
		  		break;
		  		
		  	case 2:
		  		Pagamento pagamentoAlterado = new Pagamento();
		  		System.out.println("Informe data do pagamento no formato d/MM/aaaa:");
		  		pagamentoAlterado.setData_pagamento(DateUtil.stringToDate(sc.nextLine()));;
		  		System.out.println("Valor total");
		  		pagamentoAlterado.setValor_total(new BigDecimal(Integer.parseInt(sc.nextLine())));
		  		System.out.println("Id do pagamento:");
		  		pagamentoAlterado.setId_pagamento(Integer.parseInt(sc.nextLine()));
		  		
		  		pagamentoDAO.alteraPagamento(pagamentoAlterado);
		  		break;
		  		
		  	case 3:
		  		int id;
		  		System.out.println("Id do pagamento a ser excluido:");
		  		id = Integer.parseInt(sc.nextLine());
		  		
		  		pagamentoDAO.removePagamento(id);
		  		break;
		  		
		  	case 4:
		  		pagamentoDAO.listaPagamentos();
		  		break;
		  			
 			default: System.out.println("Opcao invalida.");
		  }
	}
}
