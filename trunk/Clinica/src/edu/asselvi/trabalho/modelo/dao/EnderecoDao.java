/**
 * 
 */
package edu.asselvi.trabalho.modelo.dao;

import edu.asselvi.trabalho.modelo.entidade.Endereco;

/**
 * @author TiLL
 *
 */
public class EnderecoDao extends DaoBase {

	public void inserir(Endereco endereco) {

		conectaPeloContext();
		executeUpdate("insert into endereco (endereco, cidade, bairro, cep) values ( '" + endereco.getEndereco() + "', '" + endereco.getCidade() + "', '" + endereco.getBairro() + "', '" + endereco.getCep() + "' ) ");

		endereco.setId(getGenerationKeys());
		
	}
	
}
