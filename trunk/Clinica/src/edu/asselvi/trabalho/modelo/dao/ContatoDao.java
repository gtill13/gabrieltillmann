/**
 * 
 */
package edu.asselvi.trabalho.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.trabalho.modelo.entidade.Contato;

/**
 * @author TiLL
 * 
 */
public class ContatoDao extends DaoBase {

	public void inserir(Contato contato) {

		if (contato == null)
			return;

		conectaPeloContext();
		executeUpdate("insert into contato (email, telefone, celular) values ( '"
				+ contato.getEmail()
				+ "', '"
				+ contato.getTelefone()
				+ "', '"
				+ contato.getCelular() + "' ) ");

		contato.setId(getGenerationKeys());

	}

	public void atualizar(Contato contato) throws DaoException {

		if (contato == null)
			return;

		conecta();

		executeUpdate("update contato set email = '"
				+ contato.getEmail() + "', cidade = '"
				+ endereco.getCidade() + "', bairro = '" + endereco.getBairro()
				+ "', cep =  '" + endereco.getCep() + "' where id = '"
				+ endereco.getId() + "' ");

		endereco.setId(getGenerationKeys());
	}

	public void deletar(Endereco endereco) throws DaoException {

		conecta();

		executeUpdate("delete from endereco where id = '" + endereco.getId()
				+ "' ");
	}

	public List<Endereco> buscaTodos() {

		final List<Endereco> listEnderecos = new ArrayList<Endereco>();

		executeQuery("select * from endereco", new Mapeador<Endereco>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Endereco endereco = new Endereco();

						endereco.setId(rset.getLong("id"));
						endereco.setEndereco(rset.getString("endereco"));
						endereco.setCidade(rset.getString("cidade"));
						endereco.setBairro(rset.getString("bairro"));
						endereco.setCep(rset.getString("cep"));

						listEnderecos.add(endereco);
					}
				} catch (SQLException e) {
					throw new DaoException(
							"Banco de dados - Erro ao criar lista em "
									+ this.getClass().toString(), e);
				}
			}
		});

		return listEnderecos;
	}

	public Endereco buscaEnderecoPeloId(long id) {

		final Endereco endereco = new Endereco();

		executeQuery("select * from endereco where id = '" + id + "' ",
				new Mapeador<Endereco>() {
					public void mapear(ResultSet rset) throws DaoException {
						try {
							if (rset.next()) {

								endereco.setId(rset.getLong("id"));
								endereco.setEndereco(rset.getString("endereco"));
								endereco.setCidade(rset.getString("cidade"));
								endereco.setBairro(rset.getString("bairro"));
								endereco.setCep(rset.getString("cep"));
							}
						} catch (SQLException e) {
							throw new DaoException(
									"Banco de dados - Erro ao criar lista em "
											+ this.getClass().toString(), e);
						}
					}
				});

		return endereco;
	}

}