/**
 * 
 */
package TESTE;

/**
 * @author TiLL
 *
 */

import javax.swing.JOptionPane;

import edu.asselvi.trabalho.design.MenuPrincipal;
import edu.asselvi.trabalho.modelo.dao.PacienteDao;
import edu.asselvi.trabalho.modelo.entidade.Contato;
import edu.asselvi.trabalho.modelo.entidade.ESexo;
import edu.asselvi.trabalho.modelo.entidade.Endereco;
import edu.asselvi.trabalho.modelo.entidade.Paciente;

public final class teste {

	public static void main(String[] args) {

		switch (Integer.parseInt((JOptionPane.showInputDialog("Qual teste?")))) {
		case 1:
			teste1();
			break;

		case 2:
			teste2();
			break;

		case 3:
			teste3();
			break;
			
		case 4:
			teste4();
			break;
			
		default:
			System.out.println("ERRO");

		}

	}

	public static void teste1() {

		Paciente paciente = new Paciente("Zé Comeia", "0123456789",
				"9876543210", ESexo.M);
		PacienteDao dao = new PacienteDao();

		dao.inserirPadrao(paciente);
	}

	public static void teste2() {

		Paciente paciente = new Paciente("Zé Comeia", "0123456789",
				"9876543210", ESexo.M);
		Endereco endereco = new Endereco("End do tio", "Cid do tio",
				"Bairro do tio", "Cep do tio");
		Contato contato = new Contato("gmail@gmail.com", "3330-0505",
				"9999-8789");
		paciente.setEndereco(endereco);
		paciente.setContato(contato);

		PacienteDao dao = new PacienteDao();
		dao.inserirPadrao(paciente);
	}

	public static void teste3() {

		Paciente paciente = new Paciente("ababaca", "0123456789", "9876543210",
				ESexo.F);

		paciente.setId(4);

		PacienteDao dao = new PacienteDao();
		dao.atualizar(paciente);
		// dao.deletar(paciente);
	}
	
	public static void teste4() {
		
		MenuPrincipal menu = new MenuPrincipal();
		
		menu.showDialog(true);
		
	}
}
