package br.com.modulo3.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.modulo3.data.ConnectionFactory;
import br.com.modulo3.model.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente>{


	public void listaClientes() {
		String sql = "SELECT * FROM Cliente";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    ResultSet result = pstm.executeQuery();
		    
			lista(result);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void salvaCliente(Cliente cliente) {
		String sql = "INSERT INTO Cliente VALUES(DEFAULT, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    insere(pstm, cliente);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void removeCliente(Integer id) {
		String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    remove(pstm, id);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void alteraCliente(Cliente cliente) {
		String sql = "UPDATE Cliente SET nome = ?, email = ? WHERE id_cliente = ?";
		Connection connection = null; 
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    String sql2 = "SELECT id_cliente FROM Cliente WHERE id_cliente = ?";
		    PreparedStatement pstm2 = connection.prepareStatement(sql2);
			pstm2.setInt(1, cliente.getId_cliente());
			ResultSet result = pstm2.executeQuery();
		    if(result.next())atualiza(pstm, cliente);
		    else System.out.println("Insira um id de Cliente valido");
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	@Override
	protected void lista(ResultSet result) throws SQLException{
		while(result.next()) { 
			System.out.println(String.format("Id %s", result.getInt("id_cliente")));
			System.out.println(String.format("Nome %s", result.getString("nome")));
			System.out.println(String.format("Email %s", result.getString("email")) + "\n"); }
	}
	
	@Override
	protected void insere(PreparedStatement pstm, Cliente cliente) throws SQLException {
		pstm.setString(1, cliente.getNome());
		pstm.setString(2, cliente.getEmail());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Cliente salvo com sucesso!");
	}
	
	@Override
	protected void remove(PreparedStatement pstm, Integer idCliente) {
		boolean deuErro = true;
		try {
			pstm.setInt(1, idCliente);
		    deuErro = pstm.execute();
			
		}catch(SQLException e) {
			if(e.getErrorCode() == 1451) System.out.println("Erro de integridade, é necessário apagar o pagamento referente ao cliente");
		}
		if(!deuErro) System.out.println("Cliente removido com sucesso!");
	}
	
	@Override
	protected void atualiza(PreparedStatement pstm, Cliente cliente) throws SQLException {
		pstm.setString(1, cliente.getNome());
		pstm.setString(2, cliente.getEmail());
		pstm.setInt(3, cliente.getId_cliente());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Cliente atualizado com sucesso!");
	}
	
	
}
