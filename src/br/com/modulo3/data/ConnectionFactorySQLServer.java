package br.com.modulo3.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactorySQLServer {
	private static String CONNECTION_URL = "jdbc:sqlserver://localhost:1433;databaseName=agencia_viagem_db;user=sa;password=cr3314;encrypt=true;trustServerCertificate=true";
    private static Connection connection;
	public static Connection createConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found: " + e.getMessage());
			e.printStackTrace();
		}

		connection = DriverManager.getConnection(CONNECTION_URL);

		return connection;
  
	}

}
