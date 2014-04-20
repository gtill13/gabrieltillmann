package edu.asselvi.trabalho.modelo.dao;

import edu.asselvi.trabalho.modelo.entidade.ESexo;
import edu.asselvi.trabalho.modelo.entidade.Paciente;

public class testeBANCO {

	public static void main(String[] args) {
		
		Paciente paciente = new Paciente("Zé Comeia", "0123456789", "9876543210", ESexo.M);
		PacienteDao dao = new PacienteDao();
		
		dao.inserir(paciente);
		
		

	}

}
