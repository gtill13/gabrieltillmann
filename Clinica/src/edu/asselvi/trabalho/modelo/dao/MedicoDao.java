package edu.asselvi.trabalho.modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.asselvi.trabalho.modelo.entidade.Contato;
import edu.asselvi.trabalho.modelo.entidade.Medico;

public class MedicoDao extends DaoBase {

	public void inserirPadrao(Medico medico) throws DaoException {

		EnderecoDao enderecoDao = new EnderecoDao();
		ContatoDao contatoDao = new ContatoDao();
		conecta();
		
		executeUpdate("insert into medico (nome, crm, cpf, id_contato, id_endereco) values ( '"
				+ medico.getNome()                            + "', '" + medico.getCrm()              + "', '"
				+ medico.getCpf()                             + "', '" 
				+ contatoDao.inserirComRetorno(medico.getContato())     + "', '"
				+ enderecoDao.inserirComRetorno(medico.getEndereco())   + "' ) ");
		
		commit();

		disconecta();
	}
	
	public long inserirComRetorno(Medico medico) throws DaoException {

		if(medico == null)
			return 0;
		
		EnderecoDao enderecoDao = new EnderecoDao();
		ContatoDao contatoDao = new ContatoDao();
		conectaPeloContext();
		
		executeUpdate("insert into medico (nome, crm, cpf, id_contato, id_endereco) values ( '"
				+ medico.getNome()                            + "', '" + medico.getCrm()              + "', '"
				+ medico.getCpf()                             + "', '" 
				+ contatoDao.inserirComRetorno(medico.getContato())     + "', '"
				+ enderecoDao.inserirComRetorno(medico.getEndereco())   + "' ) ");
		
		return getGenerationKeys();
	}


	public void atualizar(Medico medico) throws DaoException {

		EnderecoDao enderecoDao = new EnderecoDao();
		ContatoDao contatoDao = new ContatoDao();
		conecta();

		enderecoDao.atualizar(medico.getEndereco());
		contatoDao .atualizar(medico.getContato ());
		
		executeUpdate("update medico set nome = '" + medico.getNome()
				+ "', crm = '" + medico.getCrm() + "', cpf = '"
				+ medico.getCpf() + "' where id = '" + medico.getId() + "' ");
		
		commit();

		disconecta();

	}
	
	public void deletar(Medico medico) throws DaoException {

		//EnderecoDao enderecoDao = new EnderecoDao();
		//ContatoDao contatoDao = new ContatoDao();
		conecta();

		executeUpdate("delete from medico where id = '" + medico.getId() + "' "); 

		//enderecoDao.deletar(paciente.getEndereco());
		//contatoDao.deletar(paciente.getContato());

		commit();

		disconecta();
	}

	public List<Medico> buscaTodos () {
		
		final List<Medico> listMedicos = new ArrayList<Medico>();
		
		executeQuery("select * from medico", new Mapeador<Medico>() {
			public void mapear(ResultSet rset) throws DaoException {
				try {
					while (rset.next()) {
						Medico medico = new Medico();
						
						medico.setId(rset.getLong("id"));
						medico.setNome(rset.getString("nome"));
						medico.setCpf(rset.getString("cpf"));
						medico.setCrm(rset.getString("crm"));
						
						listMedicos.add(medico);
					}
				} catch (SQLException e) {
					throw new DaoException("Banco de dados - Erro ao criar lista em " + this.getClass().toString(), e);
				}
			}
		});
		
		return listMedicos;
	}
	
	public Medico buscaMedicoPeloId(long id) {

		final Medico medico = new Medico();

		executeQuery("select * from medico where id = '" + id + "' ",
				new Mapeador<Medico>() {
					public void mapear(ResultSet rset) throws DaoException {
						try {
							if (rset.next()) {

								medico.setId(rset.getLong("id"));
								medico.setNome(rset.getString("nome"));
								medico.setCpf(rset.getString("cpf"));
								medico.setCrm(rset.getString("crm"));
							}
						} catch (SQLException e) {
							throw new DaoException(
									"Banco de dados - Erro ao criar lista em "
											+ this.getClass().toString(), e);
						}
					}
				});

		return medico;
	}
	
	
}
