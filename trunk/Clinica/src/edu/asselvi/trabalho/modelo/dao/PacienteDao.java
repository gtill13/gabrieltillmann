/**
 * 
 */
package edu.asselvi.trabalho.modelo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.trabalho.modelo.entidade.ESexo;
import edu.asselvi.trabalho.modelo.entidade.Paciente;

/**
 * @author TiLL
 * 
 */
public class PacienteDao extends DaoBase {

	public void inserir(Paciente paciente) throws DaoException {

		EnderecoDao enderecoDao = new EnderecoDao();
		ContatoDao contatoDao = new ContatoDao();
		conecta();

		executeUpdate("insert into paciente (nome, rg, cpf, sexo) values ( '"
				+ paciente.getNome() + "', '" + paciente.getRg() + "', '"
				+ paciente.getCpf() + "', '" + paciente.getSexo() + "' ) ");

		enderecoDao.inserir(paciente.getEndereco());
		contatoDao.inserir(paciente.getContato());

		commit();

		disconecta();
	}

	public void atualizar(Paciente paciente) throws DaoException {

		//EnderecoDao enderecoDao = new EnderecoDao();
		//ContatoDao contatoDao = new ContatoDao();
		conecta();

		executeUpdate("update paciente set nome = '" + paciente.getNome()
				+ "', rg = '" + paciente.getRg() + "', cpf = '"
				+ paciente.getCpf() + "', sexo =  '" + paciente.getSexo()
				+ "' where id = '" + paciente.getId() + "' ");

		//enderecoDao.atualizar(paciente.getEndereco());
		//contatoDao.atualizar(paciente.getContato());

		commit();

		disconecta();

	}
	
	public void deletar(Paciente paciente) throws DaoException {

		//EnderecoDao enderecoDao = new EnderecoDao();
		//ContatoDao contatoDao = new ContatoDao();
		conecta();

		executeUpdate("delete from paciente where id = '" + paciente.getId() + "' "); 

		//enderecoDao.deletar(paciente.getEndereco());
		//contatoDao.deletar(paciente.getContato());

		commit();

		disconecta();
	}

	public List<Paciente> buscaTodos () {
		
		final List<Paciente> listPacientes = new ArrayList<Paciente>();
		
		executeQuery("select * from paciente", new Mapeador<Paciente>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Paciente paciente = new Paciente();
						
						paciente.setId(rset.getLong("id"));
						paciente.setNome(rset.getString("nome"));
						paciente.setCpf(rset.getString("cpf"));
						paciente.setRg(rset.getString("rg"));
						paciente.setSexo(ESexo.valueOf(rset.getString("sexo")));

						listPacientes.add(paciente);
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				}
			}
		});
		
		return listPacientes;
	}
	
} 

