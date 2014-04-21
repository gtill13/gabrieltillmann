/**
 * 
 */
package edu.asselvi.trabalho.modelo.dao;

import edu.asselvi.trabalho.modelo.entidade.Contato;

/**
 * @author TiLL
 *
 */
public class ContatoDao extends DaoBase {
	
	public void inserir(Contato contato) {

		conectaPeloContext();
		executeUpdate("insert into contato (email, telefone, celular) values ( '" + contato.getEmail() + "', '" + contato.getTelefone() + "', '" + contato.getCelular() + "' ) ");

		contato.setId(getGenerationKeys());
		
	}
	
} 