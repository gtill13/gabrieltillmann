package edu.asselvi.trabalho.design;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import edu.asselvi.trabalho.modelo.dao.ConsultaDao;
import edu.asselvi.trabalho.modelo.dao.MedicoDao;
import edu.asselvi.trabalho.modelo.dao.PacienteDao;
import edu.asselvi.trabalho.modelo.entidade.Consulta;
import edu.asselvi.trabalho.modelo.entidade.Medico;
import edu.asselvi.trabalho.modelo.entidade.Paciente;

public class MenuRelatorio extends DesignBase {

	public static void start() {
		startRelatorio();
	}

	private static void startRelatorio() {
		clearConsole();

		int codigo = -1;
		while (codigo != 0) {
			System.out.println("1 - Relatorio de Medico");
			System.out.println("2 - Relatorio de Paciente");
			System.out.println("3 - Relatorio de Consultas");
			System.out.println("9 - Help");
			System.out.println("0 - Sair");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				codigo = Integer.parseInt(buffer.readLine());
				executeActionRelatorio(codigo);
			} catch (IOException e ) {
				// throw new RuntimeException(e);
				System.out.println("Opção Incorreta");
			}
		}
	}
	
	private static void executeActionRelatorio(int codigo) throws IOException {

		clearConsole();

		switch (codigo) {
		case 1:
			relatorioMedicos();
			break;
		case 2:
			relatorioPacientes();
			break;
		case 3:
			relatorioConsultas();
			break;
		case 9:
			System.out
			.println("Informe qual relatorio deseja visualizar, o relatorio é salvo na pasta de execução do RetroClinic");
			break;
		}
	}

	private static void relatorioConsultas() throws IOException {
		ConsultaDao consultaDao = new ConsultaDao();
		List<Consulta> listConsulta = consultaDao.buscaTodos();
		FileWriter arq = new FileWriter("c:\\relatorioConsultas.txt"); 
		PrintWriter gravarArq = new PrintWriter(arq);
		
		System.out.println("===========================");
		gravarArq.printf("===========================%n");
		System.out.println("|    Lista das Consulta   |");
		gravarArq.printf("|    Lista das Consulta   |%n");
		System.out.println("===========================");
		gravarArq.printf("===========================%n");
		
		for (Consulta consulta : listConsulta) {
			System.out.println(consulta.toString());
			gravarArq.printf(consulta.toString()+"%n");
		}
		
		gravarArq.close();
	}

	private static void relatorioPacientes() throws IOException {
		PacienteDao pacienteDao = new PacienteDao();
		List<Paciente> listPaciente = pacienteDao.buscaTodos();
		FileWriter arq = new FileWriter("c:\\relatorioPacientes.txt"); 
		PrintWriter gravarArq = new PrintWriter(arq);
		
		System.out.println("===========================");
		gravarArq.printf("===========================%n");
		System.out.println("|    Lista das Pacinete   |");
		gravarArq.printf("|    Lista das Paciente   |%n");
		System.out.println("===========================");
		gravarArq.printf("===========================%n");
		
		for (Paciente paciente : listPaciente) {
			System.out.println(paciente.toString());
			gravarArq.printf(paciente.toString()+"%n");
		}
		gravarArq.close();
	}

	private static void relatorioMedicos() throws IOException {
		MedicoDao medicoDao = new MedicoDao();
		List<Medico> listMedico = medicoDao.buscaTodos();
		FileWriter arq = new FileWriter("c:\\relatorioMedicos.txt"); 
		PrintWriter gravarArq = new PrintWriter(arq);
		
		System.out.println("=========================");
		gravarArq.printf("=========================%n");
		System.out.println("|    Lista das Medico   |");
		gravarArq.printf("|    Lista das Medico   |%n");
		System.out.println("=========================");
		gravarArq.printf("=========================%n");
		
		for (Medico medico : listMedico) {
			System.out.println(medico.toString());
			gravarArq.printf(medico.toString()+"%n");
		}
		gravarArq.close();
	}
}
