package edu.asselvi.trabalho.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import edu.asselvi.trabalho.modelo.dao.ConsultaDao;
import edu.asselvi.trabalho.modelo.dao.MedicoDao;
import edu.asselvi.trabalho.modelo.dao.PacienteDao;
import edu.asselvi.trabalho.modelo.entidade.Consulta;
import edu.asselvi.trabalho.modelo.entidade.Medicamento;
import edu.asselvi.trabalho.modelo.entidade.Medico;
import edu.asselvi.trabalho.modelo.entidade.Paciente;
import edu.asselvi.trabalho.modelo.entidade.Pagamento;

public class MenuConsulta extends DesignBase {

	public static void start() {
		startConsulta();
	}

	private static void startConsulta() {

		clearConsole();

		int codigo = -1;
		while (codigo != 0) {
			System.out.println("1 - Nova Consulta");
			System.out.println("2 - Verificar Consulta");
			System.out.println("9 - Help");
			System.out.println("0 - Sair");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				codigo = Integer.parseInt(buffer.readLine());
				executeActionConsulta(codigo);
			} catch (IOException e) {
				// throw new RuntimeException(e);
				System.out.println("Opção Incorreta");
			}
		}

	}

	private static void executeActionConsulta(int codigo) throws IOException {

		clearConsole();

		switch (codigo) {
		case 1:
			novaConsulta();
			break;
		case 2:
			verificarConsulta();
			break;
		case 9:
			System.out
					.println("Informe a operação que deseja realizar para uma consulta");
			break;
		}
	}

	private static void novaConsulta() throws NumberFormatException,
			IOException {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));

		ConsultaDao consultaDao = new ConsultaDao();
		PacienteDao pacienteDao = new PacienteDao();
		MedicoDao medicoDao = new MedicoDao();

		Consulta consulta = new Consulta();
		List<Medico> listMedico = medicoDao.buscaTodos();
		List<Paciente> listPaciente = pacienteDao.buscaTodos();
		Medicamento medicamento = new Medicamento();
		Pagamento pagamento = new Pagamento();

		System.out.println("======================");
		System.out.println("|   Nova Consulta    |");
		System.out.println("======================");

		consulta.setDataCriacao(new Date());

		for (;;) {
			for (Medico medico : listMedico) {
				System.out.println(medico.toString());
			}

			System.out.println("Informe o ID do Medico para a consulta:");
			long idMedico = Long.parseLong(buffer.readLine());

			Medico medico = medicoDao.buscaMedicoPeloId(idMedico);
			if (medico.getId() == 0)
				System.out.println("Medico não cadastrado");
			else {
				consulta.setMedico(medico);
				break;
			}
		}

		for (;;) {
			for (Paciente paciente : listPaciente) {
				System.out.println(paciente.toString());
			}

			System.out.println("Informe o ID do Paciente para a consulta:");
			long idPaciente = Long.parseLong(buffer.readLine());

			Paciente paciente = pacienteDao.buscaPacientePeloId(idPaciente);
			if (paciente.getId() == 0)
				System.out.println("Paciente não cadastrado");
			else {
				consulta.setPaciente(paciente);
				break;
			}
		}

		System.out.println("Nome do medicamento:");
		medicamento.setNome(buffer.readLine());
		System.out.println("Descrição do medicamento:");
		medicamento.setDescricao(buffer.readLine());

		// System.out.println("Informe a data do pagamento:");
		// pagamento.setDataPagamento(new Date(buffer.readLine()));
		// System.out.println("Informe a data do vencimento:");
		// pagamento.setDataPagamento(new Date(buffer.readLine()));
		System.out.println("Informe o valor:");
		pagamento.setValor(Double.parseDouble(buffer.readLine()));

		consulta.setMedicamento(medicamento);
		consulta.setPagamento(pagamento);

		if (checaDadosConsulta(consulta)) {
			consultaDao.inserirPadrao(consulta);
			System.out.println("Consulta evetuada com sucesso.");
		} else {
			System.out
					.println("Foram encontrados erros na consulta. Favor  tentar novamente");
		}
	}

	private static boolean checaDadosConsulta(Consulta consulta) {
		// TODO Auto-generated method stub
		// nao sei oq verificar mais se um dia precisar
		return true;
	}

	private static void verificarConsulta() throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub
		ConsultaDao ConsultaDao = new ConsultaDao();
		List<Consulta> listConsulta = ConsultaDao.buscaTodos();

		MedicoDao medicoDao = new MedicoDao();
		List<Medico> listMedico = medicoDao.buscaTodos();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("===========================");
		System.out.println("|    Lista dos Medicos    |");
		System.out.println("===========================");

		for (Medico medico : listMedico) {
			System.out.println(medico.toString());
		}

		System.out
				.println("Informe o ID do medico que deseja vizualizar as consultas:");
		long idMedico = Long.parseLong(buffer.readLine());

		System.out.println("===========================");
		System.out.println("|    Lista das Consulta   |");
		System.out.println("===========================");

		for (Consulta consulta : listConsulta) {
			if (idMedico == consulta.getMedico().getId())
				System.out.println(consulta.toString());
		}
	}
}
