package br.com.modulo3.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAO<T> {
	
	
	protected abstract void lista(ResultSet result) throws SQLException;
	
	protected abstract void insere(PreparedStatement pstm, T data) throws SQLException;
	
	protected abstract  void remove(PreparedStatement pstm, Integer id) throws SQLException;
	
	protected abstract void atualiza(PreparedStatement pstm, T data) throws SQLException;
		
	protected void fecharConexao(Connection connection, PreparedStatement pstm) {
		try {
			if( connection != null ) connection.close();
			if( pstm != null ) pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
