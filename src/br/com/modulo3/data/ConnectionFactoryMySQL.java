package br.com.modulo3.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryMySQL implements AutoCloseable{

	//private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String URL = "jdbc:mysql://localhost:3306/agencia_viagem_db?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "user2";
	private static final String PASSWORD = "cr3314";
    private static Connection connection;
    
	public static Connection createConnection() throws SQLException {
		/*
		 * try { Class.forName(DRIVER); } catch (ClassNotFoundException e) {
		 * System.out.println("Driver not found: " + e.getMessage());
		 * e.printStackTrace(); }
		 */
		connection = DriverManager.getConnection(URL, USER, PASSWORD);

		return connection;
  
	}

	@Override
	public void close() throws Exception {
		connection.close();
		System.out.println("Fechando conex�o");
	}
}
