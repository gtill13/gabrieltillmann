package edu.asselvi.trabalho.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import edu.asselvi.trabalho.framework.dao.DaoException;
import edu.asselvi.trabalho.framework.dao.Mapeador;

public class DaoBase {

	private static final ThreadLocal<Connection> context = new ThreadLocal<Connection>();
	private Statement statement;
	private ResultSet rset;

	public long getGenerationKeys() throws DaoException {
		try {
			if (rset.next())
				return rset.getLong(1);
			else
				throw new DaoException(
						"Banco de dados - Erro ao buscar generation Keys!");
		} catch (SQLException e) {
			throw new DaoException(
					"Banco de dados - Erro ao buscar generation Keys!", e);
		}
	}

	public void conectaPeloContext() throws DaoException {

		if(context.get() == null)
			throw new DaoException("Banco de dados - Erro falha no contexto!");
		
		Connection connection = null;
		try {
			connection = context.get();

			statement = connection.createStatement();
			System.out.println("Banco de dados - Conectado!");
		} catch (SQLException e) {
			throw new DaoException("Banco de dados - Erro ao tentar conectar!",
					e);
			// System.out.println("Banco de dados - Erro ao tentar conectar!");
		}

	}

	public void conecta() throws DaoException {
		try {

			Connection connection = null;

			if (context.get() == null) {

				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/clinicabd",
								"root", "1234");
				connection.setAutoCommit(false);
				context.set(connection);

			} else {
				connection = context.get();
			}

			statement = connection.createStatement();
			System.out.println("Banco de dados - Conectado!");
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException("Banco de dados - Erro ao tentar conectar!",
					e);
			// System.out.println("Banco de dados - Erro ao tentar conectar!");
		}
	}

	public void disconecta() throws DaoException {
		try {
			if (statement != null)
				statement.close();
			if (context.get() != null) {
				context.get().close();
				context.remove();
			}
		} catch (SQLException e) {
			throw new DaoException(
					"Banco de dados - Erro ao tentar disconectar!", e);
			// System.out.println("Banco de dados - Erro ao tentar disconectar!");
		}
	}

	public void executeUpdate(String sql) throws DaoException {

		if (statement == null) {
			throw new DaoException(
					"Banco de dados - Erro ao tentar disconectar!");
			// System.out.println("Banco de dados - Não conectado!");
		}

		try {
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			setRset(statement.getGeneratedKeys());

		} catch (SQLException e) {
			throw new DaoException(
					"Banco de dados - Falha ao executar comando: " + sql, e);
			// System.out.println("Banco de dados - Falha ao executar comando: "
			// + sql);
		}

	}

	private void setRset(ResultSet rset) {
		this.rset = rset;
	}

	public void commit() throws DaoException {
		if (context.get() == null)
			throw new DaoException("Banco de dados - Sem conexão!");

		try {
			context.get().commit();
		} catch (SQLException e) {
			throw new DaoException("Banco de dados - Falha ao comitar!");
		}

	}
	
	public <T> void executeQuery(String sql, Mapeador<T> map) throws DaoException {
		
		conecta();
		
		try {
			map.mapear(statement.executeQuery(sql));
		} catch (SQLException e) {
			throw new DaoException("Banco de dados - Erro ao executar comando: " + sql, e);
		} finally {
			disconecta();
		}
	}
}
