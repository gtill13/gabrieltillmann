/**
 * 
 */
package edu.asselvi.trabalho.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import edu.asselvi.trabalho.modelo.dao.DaoBase;
import edu.asselvi.trabalho.modelo.dao.DaoException;

/**
 * @author TiLl
 * 
 */
public class RetroClinic extends DesignBase {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		DaoBase dao = new DaoBase();
		try{
		dao.conecta();
		dao.disconecta();
		}
		catch(DaoException e){
			dao.CriaBanco();
		}
		
		int codigo = -1;
		while (codigo != 0) {
			System.out.println("1 - Cadastros");
			System.out.println("2 - Consulta Clínica");
			System.out.println("3 - Relatorio");
			System.out.println("9 - Help");
			System.out.println("0 - Sair");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				codigo = Integer.parseInt(buffer.readLine());
				executeActionMain(codigo);
			} catch (IOException e) {
				//throw new RuntimeException(e);
				System.out.println("Opção Incorreta");
			}
		}
	}

	private static void executeActionMain(int codigo) {
		switch (codigo) {
		case 1:
			MenuCadastro.start(); 
			break;
		case 2:
			MenuConsulta.start();
			break;
		case 3:
			MenuRelatorio.start();
			break;
		case 9:
			System.out.println("Informe o que deseja que o sistema realize.");
			break;
		}
	}
	


}
