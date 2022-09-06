package br.com.modulo3.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import br.com.modulo3.data.ConnectionFactoryMySQL;
import br.com.modulo3.model.Pagamento;
import utils.DateUtil;

public class PagamentoDAO extends AbstractDAO<Pagamento>{

	
	public void listaPagamentos() {
		String sql = "SELECT * FROM Pagamento";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactoryMySQL.createConnection();
		    pstm = connection.prepareStatement(sql);
		    ResultSet result = pstm.executeQuery();
		    
			lista(result);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void salvaPagamento(Pagamento pagamento) {
		String sql = "INSERT INTO Pagamento VALUES(DEFAULT, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactoryMySQL.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    insere(pstm, pagamento);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void removePagamento(Integer id) {
		String sql = "DELETE FROM Pagamento WHERE id_pagamento = ?";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactoryMySQL.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    String sql2 = "SELECT id_pagamento FROM Pagamento WHERE id_pagamento = ?";
		    PreparedStatement pstm2 = connection.prepareStatement(sql2);
			pstm2.setInt(1, id);
			ResultSet result = pstm2.executeQuery();
		    if(result.next()) remove(pstm, id);
		    else System.out.println("Pagamento com o id informado eh inexistente");
			
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void alteraPagamento(Pagamento pagamento) {
		
		String sql = "UPDATE Pagamento SET valor_total = ?, data_pagamento = ? "
				+ "WHERE id_pagamento = ?";
		
		Connection connection = null; 
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactoryMySQL.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    String sql2 = "SELECT id_pagamento FROM Pagamento WHERE id_pagamento = ?";
		    PreparedStatement pstm2 = connection.prepareStatement(sql2);
			pstm2.setInt(1, pagamento.getId_pagamento());
			ResultSet result = pstm2.executeQuery();
		    if(result.next()) atualiza(pstm, pagamento);
		    else System.out.println("Insira um id valido.");
		    
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	@Override
	protected void lista(ResultSet result) throws SQLException {
		while(result.next()) {
			System.out.println("\n" + String.format("Id %d", result.getInt("id_pagamento")));
			System.out.println(String.format("Valor total %.2f ", result.getBigDecimal("valor_total")));
			System.out.println(String.format("Data Pagamento %s ", DateUtil.DateToString(result.getDate("data_pagamento"))));
			System.out.println(String.format("Id do cliente %d ", result.getInt("id_cliente")));
			System.out.println(String.format("Id do pacote %d ", result.getInt("id_pacote"))+ "\n");
		}
		
	}

	@Override
	protected void insere(PreparedStatement pstm, Pagamento data) {
		boolean temErro = true;
		
		try {
			pstm.setBigDecimal(1, data.getValor_total());
			pstm.setDate(2, new Date(data.getData_pagamento().getTime()));
			pstm.setInt(3, data.getId_cliente());
			pstm.setInt(4, data.getId_pacote());
			temErro = pstm.execute();
			
		} catch (SQLException e) {
			if(e.getErrorCode() == 1452 || e.getErrorCode() == 547) 
				System.out.println("Erro de de integridade, deve haver um id de pacote e de cliente validos");
		}
		
		if(!temErro)
			System.out.println("Pagamento criado com sucesso!");
		
	}

	@Override
	protected void remove(PreparedStatement pstm, Integer id) throws SQLException {
		pstm.setInt(1, id);
		boolean temErro = pstm.execute();
	
		if(!temErro) System.out.println("Pagamento removido com sucesso");
	}

	@Override
	protected void atualiza(PreparedStatement pstm, Pagamento data) throws SQLException {
		pstm.setBigDecimal(1, data.getValor_total());
		pstm.setDate(2, new Date(data.getData_pagamento().getTime()));
		pstm.setInt(3, data.getId_pagamento());
		boolean temErro = pstm.execute();
		
		if(!temErro) System.out.println("Pagamento alterado com exito!");
		
	}



}
