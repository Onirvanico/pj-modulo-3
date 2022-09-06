package br.com.modulo3.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.modulo3.data.ConnectionFactoryMySQL;
import br.com.modulo3.model.Pacote;
import utils.DateUtil;

public class PacoteDAO extends AbstractDAO<Pacote> {

	public void listaPacotes() {
		String sql = "SELECT * FROM Pacote";
		
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
	
	public void salvaPacote(Pacote pacote) {
		String sql = "INSERT INTO Pacote VALUES(DEFAUT, ?, ?, ?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactoryMySQL.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    insere(pstm, pacote);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void removePacote(Integer id) {
		String sql = "DELETE FROM Pacote WHERE id_pacote = ?";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactoryMySQL.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    String sql2 = "SELECT id_pacote FROM Pacote WHERE id_pacote = ?";
		    PreparedStatement pstm2 = connection.prepareStatement(sql2);
			pstm2.setInt(1, id);
			ResultSet result = pstm2.executeQuery();
		    if(result.next()) remove(pstm, id);
		    else System.out.println("Pacote com o id informado eh inexistente");
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void alteraPacote(Pacote pacote) {
		String sql = "UPDATE Pacote SET num_viajantes = ?, destino = ?, data_inicio = ?, "
				+ "data_fim = ?, titulo = ?, descricao = ?, "
				+ "preco = ? WHERE id_pacote = ?";
		
		Connection connection = null; 
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactoryMySQL.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    String sql2 = "SELECT id_pacote FROM Pacote WHERE id_pacote = ?";
		    PreparedStatement pstm2 = connection.prepareStatement(sql2);
			pstm2.setInt(1, pacote.getId_pacote());
			ResultSet result = pstm2.executeQuery();
		    if(result.next()) atualiza(pstm, pacote);
		    else System.out.println("Insira um id valido");
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	@Override
	protected void lista(ResultSet result) throws SQLException{
		while(result.next()) { 
			System.out.println("\n" + String.format("Id: %s", result.getInt("id_pacote")));
			System.out.println(String.format("Numero de viajantes: %d", result.getInt("num_viajantes")));
			System.out.println(String.format("Destino:: %s", result.getString("destino")));
			System.out.println(String.format("Data inicio: %s", DateUtil.DateToString(result.getDate("data_inicio")))); 
			System.out.println(String.format("Data fim: %s", DateUtil.DateToString(result.getDate("data_fim"))));
			System.out.println(String.format("Titulo: %s", result.getString("titulo")));
			System.out.println(String.format("Descricao: %s", result.getString("descricao")));
			System.out.println(String.format("Preco: %.2f", result.getBigDecimal("preco")) + "\n");
		}
	}
	
	@Override
	protected void insere(PreparedStatement pstm, Pacote pacote) throws SQLException {
		pstm.setInt(1, pacote.getNum_viajantes());
		pstm.setString(2, pacote.getDestino());
		pstm.setDate(3, new Date(pacote.getData_inicio().getTime()));
		pstm.setDate(4, new Date(pacote.getData_fim().getTime()));
		pstm.setString(5, pacote.getTitulo());
		pstm.setString(6, pacote.getDescricao());
		pstm.setBigDecimal(7, pacote.getPreco());
		boolean deuErro = pstm.execute();
		
		if(!deuErro) System.out.println("Pacote salvo com sucesso!");
	}
	
	@Override
	protected void remove(PreparedStatement pstm, Integer idPacote) {
		boolean deuErro = true;
		try {
			pstm.setInt(1, idPacote);
		    deuErro = pstm.execute();
		} catch (SQLException e) {
			if(e.getErrorCode() == 1451 || e.getErrorCode() == 547) 
				System.out.println("Erro de integridade, e necessario remover o registro de pagamento associado");
		}
		if(!deuErro) System.out.println("Pacote removido com sucesso!");
	}
	
	@Override
	protected void atualiza(PreparedStatement pstm, Pacote pacote) throws SQLException {
		pstm.setInt(1, pacote.getNum_viajantes());
		pstm.setString(2, pacote.getDestino());
		pstm.setDate(3, new Date(pacote.getData_inicio().getTime()));
		pstm.setDate(4, new Date(pacote.getData_fim().getTime()));
		pstm.setString(5, pacote.getTitulo());
		pstm.setString(6, pacote.getDescricao());
		pstm.setBigDecimal(7, pacote.getPreco());
		pstm.setInt(8,  pacote.getId_pacote());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Pacote atualizado com sucesso!");
	}

	
}
