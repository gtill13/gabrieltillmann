/**
 * 
 */
package edu.asselvi.trabalho.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author TiLl
 * 
 */
public class RetroClinic extends DesignBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
			System.out.println("Relatorio");
			break;
		case 9:
			System.out.println("executou 2");
			break;
		}
	}
	


}
