package edu.asselvi.trabalho.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import edu.asselvi.trabalho.framework.dao.DaoException;


public class DaoBase {

	private static final ThreadLocal<Connection> context = new ThreadLocal<Connection>();
	
	private Connection connection;
	private Statement statement;
	
	public void Conecta() throws DaoException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicabd", "root", "1234");
			statement  = connection.createStatement();
			System.out.println("Banco de dados - Conectado!");
		}
		catch (ClassNotFoundException | SQLException e) {
			throw new DaoException("Banco de dados - Erro ao tentar conectar!", e);
			//System.out.println("Banco de dados - Erro ao tentar conectar!");
		}
	}
	
	public void Disconecta() throws DaoException {
		try {
			if (statement != null)			
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			throw new DaoException("Banco de dados - Erro ao tentar disconectar!", e);
			//System.out.println("Banco de dados - Erro ao tentar disconectar!");
		}
	}

	public void executeUpdate(String sql) throws DaoException {
		
		if (statement == null) {
			throw new DaoException("Banco de dados - Erro ao tentar disconectar!");
			//System.out.println("Banco de dados - Não conectado!");
		}
			
		try {
			statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			throw new DaoException("Banco de dados - Falha ao executar comando: " + sql, e);
			//System.out.println("Banco de dados - Falha ao executar comando: " + sql);
		}

	}
}
