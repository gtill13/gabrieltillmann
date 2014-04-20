/**
 * 
 */
package edu.asselvi.trabalho.modelo.dao;

import edu.asselvi.trabalho.framework.dao.DaoException;
import edu.asselvi.trabalho.modelo.entidade.Paciente;

/**
 * @author TiLL
 *
 */
public class PacienteDao extends DaoBase {

	public void inserir (Paciente paciente) throws DaoException {
		
			Conecta();
			executeUpdate("insert into paciente (nome, rg, cpf, sexo) values ( '" + paciente.getNome() + "', '" + paciente.getRg() + "', '" + paciente.getCpf() + "', '" + paciente.getSexo() + "' ) ");
			Disconecta();		
	}
	
}
