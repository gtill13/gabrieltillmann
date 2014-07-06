package edu.asselvi.trabalho.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import edu.asselvi.trabalho.modelo.dao.MedicoDao;
import edu.asselvi.trabalho.modelo.dao.PacienteDao;
import edu.asselvi.trabalho.modelo.entidade.Contato;
import edu.asselvi.trabalho.modelo.entidade.ESexo;
import edu.asselvi.trabalho.modelo.entidade.Endereco;
import edu.asselvi.trabalho.modelo.entidade.Medico;
import edu.asselvi.trabalho.modelo.entidade.Paciente;

public class MenuCadastro extends DesignBase {

	public static void start() {
		startCadastro();
	}
	
	private static void startCadastro() {

		clearConsole();

		int codigo = -1;
		while (codigo != 0) {
			System.out.println("1 - Medico");
			System.out.println("2 - Paciente");
			System.out.println("9 - Help");
			System.out.println("0 - Sair");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				codigo = Integer.parseInt(buffer.readLine());
				executeActionCadastro(codigo);
			} catch (IOException e ) {
				// throw new RuntimeException(e);
				System.out.println("Opção Incorreta");
			}
		}

	}

	private static void executeActionCadastro(int codigo) throws IOException {
		
		if (codigo == 0)
			return;
		
		int codigo2 = -1;
		while (codigo2 != 0) {
			System.out.println("1 - Adicionar");
			System.out.println("2 - Alterar");
			System.out.println("3 - Remover");
			System.out.println("9 - Help");
			System.out.println("0 - Sair");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				codigo2 = Integer.parseInt(buffer.readLine());
				executeActionAAR(codigo, codigo2);
			} catch (IOException e) {
				// throw new RuntimeException(e);
				System.out.println("Opção Incorreta");
			}
		}
	}

	private static void executeActionAAR(int codigo, int codigo2) throws IOException {
		clearConsole();
		
		switch (codigo) {
		case 1: {
			switch (codigo2) {
			case 1:
				cadastroMedico();
				break;
			case 2:
				alterarMedico();
				break;
			case 3:
				removerMedico();
				break;
			case 9:
				break;
			}
		}
			break;
		case 2: {
			switch (codigo2) {
			case 1:
				cadastroPaciente();
				break;
			case 2:
				alterarPaciente();
				break;
			case 3:
				removerPaciente();
				break;
			case 9:
				break;
			}
		}
			break;
		case 9:
			System.out.println("help");
			break;
		}
	}

	private static void cadastroMedico() throws IOException {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));

		Medico medico = new Medico();
		Contato contato = new Contato();
		Endereco endereco = new Endereco();

		System.out.println("============================");
		System.out.println("|   Cadastro de Medicos    |");
		System.out.println("============================");

		System.out.println("Nome:");
		medico.setNome(buffer.readLine());
		System.out.println("Crm:");
		medico.setCrm(buffer.readLine());
		System.out.println("CPF:");
		medico.setCpf(buffer.readLine());

		System.out.println("==============================");
		System.out.println("|   Informações do Endereco  |");
		System.out.println("|   Opcional                 |");
		System.out.println("==============================");

		System.out.println("Cidade:");
		endereco.setCidade(buffer.readLine());
		System.out.println("CEP:");
		endereco.setCep(buffer.readLine());
		System.out.println("Bairro:");
		endereco.setBairro(buffer.readLine());
		System.out.println("Endereço:");
		endereco.setEndereco(buffer.readLine());

		System.out.println("==============================");
		System.out.println("|   Informações de Contato   |");
		System.out.println("|   Opcional                 |");
		System.out.println("==============================");

		System.out.println("Telefone:");
		contato.setTelefone(buffer.readLine());
		System.out.println("Celular:");
		contato.setCelular(buffer.readLine());
		System.out.println("Email:");
		contato.setEmail(buffer.readLine());

		medico.setEndereco(endereco);
		medico.setContato(contato);

		if (checaDadosMedico(medico)) {
			MedicoDao dao = new MedicoDao();
			dao.inserirPadrao(medico);
			System.out
					.println("Medico cadastrado com sucesso.");
		} else {
			System.out
					.println("Foram encontrados erros no cadastro. Favor  tentar novamente");
		}
	}

	private static void alterarMedico() throws IOException {
		MedicoDao dao = new MedicoDao();
		List<Medico> listMedico = dao.buscaTodos();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		
		System.out.println("===========================");
		System.out.println("|    Lista dos Medicos    |");
		System.out.println("===========================");
		
		for (Medico medico : listMedico) {
			System.out.println(medico.toString());
		}
		
		System.out.println("Informe o ID do Medico que deseja alterar:");
		long idMedico = Long.parseLong(buffer.readLine());
		
		Medico medico = dao.buscaMedicoPeloId(idMedico);
		
        if(medico.getId() == 0)
        {
    		System.out.println("Opção incorreta:");
        	return;
        }
		
		Contato contato = new Contato();
		Endereco endereco = new Endereco();

		System.out.println("============================");
		System.out.println("|   Cadastro de Medicos    |");
		System.out.println("============================");

		System.out.println("Nome:");
		medico.setNome(buffer.readLine());
		System.out.println("Crm:");
		medico.setCrm(buffer.readLine());
		System.out.println("CPF:");
		medico.setCpf(buffer.readLine());

		System.out.println("==============================");
		System.out.println("|   Informações do Endereco  |");
		System.out.println("|   Opcional                 |");
		System.out.println("==============================");

		System.out.println("Cidade:");
		endereco.setCidade(buffer.readLine());
		System.out.println("CEP:");
		endereco.setCep(buffer.readLine());
		System.out.println("Bairro:");
		endereco.setBairro(buffer.readLine());
		System.out.println("Endereço:");
		endereco.setEndereco(buffer.readLine());

		System.out.println("==============================");
		System.out.println("|   Informações de Contato   |");
		System.out.println("|   Opcional                 |");
		System.out.println("==============================");

		System.out.println("Telefone:");
		contato.setTelefone(buffer.readLine());
		System.out.println("Celular:");
		contato.setCelular(buffer.readLine());
		System.out.println("Email:");
		contato.setEmail(buffer.readLine());
		
		medico.setEndereco(endereco);
		medico.setContato(contato);

		if (checaDadosMedico(medico)) {
			dao.atualizar(medico);
			System.out
					.println("Medico cadastrado com sucesso.");
		} else {
			System.out
					.println("Foram encontrados erros no cadastro. Favor  tentar novamente");
		}
		
	}
	
	private static void removerMedico() throws IOException {
		MedicoDao dao = new MedicoDao();
		List<Medico> listMedico = dao.buscaTodos();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		
		System.out.println("===========================");
		System.out.println("|    Lista dos Medicos    |");
		System.out.println("===========================");
		
		for (Medico medico : listMedico) {
			System.out.println(medico.toString());
		}
		
		System.out.println("Informe o ID do Medico que deseja remover:");
		long idMedico = Long.parseLong(buffer.readLine());
		
		dao.deletar(idMedico);	
	}
	
	private static boolean checaDadosMedico(Medico medico) {

		if (medico.getNome().isEmpty() || medico.getCrm().isEmpty()
				|| medico.getCpf().isEmpty())
			return false;

		return true;
	}

	private static void cadastroPaciente() throws IOException {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));

		Paciente paciente = new Paciente();
		Contato contato = new Contato();
		Endereco endereco = new Endereco();

		System.out.println("============================");
		System.out.println("|   Cadastro de Paciente   |");
		System.out.println("============================");

		System.out.println("Nome:");
		paciente.setNome(buffer.readLine());
		System.out.println("Rg:");
		paciente.setRg(buffer.readLine());
		System.out.println("CPF:");
		paciente.setCpf(buffer.readLine());
		System.out.println("Sexo:");
		paciente.setSexo(Character.toLowerCase(buffer.readLine().charAt(0)) == 'f' ? ESexo.F
				: ESexo.M);

		System.out.println("==============================");
		System.out.println("|   Informações do Endereco  |");
		System.out.println("|   Opcional                 |");
		System.out.println("==============================");

		System.out.println("Cidade:");
		endereco.setCidade(buffer.readLine());
		System.out.println("CEP:");
		endereco.setCep(buffer.readLine());
		System.out.println("Bairro:");
		endereco.setBairro(buffer.readLine());
		System.out.println("Endereço:");
		endereco.setEndereco(buffer.readLine());

		System.out.println("==============================");
		System.out.println("|   Informações de Contato   |");
		System.out.println("|   Opcional                 |");
		System.out.println("==============================");

		System.out.println("Telefone:");
		contato.setTelefone(buffer.readLine());
		System.out.println("Celular:");
		contato.setCelular(buffer.readLine());
		System.out.println("Email:");
		contato.setEmail(buffer.readLine());

		paciente.setEndereco(endereco);
		paciente.setContato(contato);

		if (checaDadosPaciente(paciente)) {
			PacienteDao dao = new PacienteDao();
			dao.inserirPadrao(paciente);
			System.out
			.println("Paciente cadastrado com sucesso.");

		} else {
			System.out
					.println("Foram encontrados erros no cadastro. Favor  tentar novamente");
		}
	}

	private static void alterarPaciente() throws IOException {
		PacienteDao dao = new PacienteDao();
		List<Paciente> listPaciente = dao.buscaTodos();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		
		System.out.println("===========================");
		System.out.println("|    Lista dos Pacientes    |");
		System.out.println("===========================");
		
		for (Paciente paciente : listPaciente) {
			System.out.println(paciente.toString());
		}
		
		System.out.println("Informe o ID do Paciente que deseja alterar:");
		long idMedico = Long.parseLong(buffer.readLine());
		
		Paciente paciente = dao.buscaPacientePeloId(idMedico);
		
        if(paciente.getId() == 0)
        {
    		System.out.println("Opção incorreta:");
        	return;
        }
		
		Contato contato = new Contato();
		Endereco endereco = new Endereco();

		System.out.println("============================");
		System.out.println("|   Cadastro de Paciente   |");
		System.out.println("============================");

		System.out.println("Nome:");
		paciente.setNome(buffer.readLine());
		System.out.println("Rg:");
		paciente.setRg(buffer.readLine());
		System.out.println("CPF:");
		paciente.setCpf(buffer.readLine());
		System.out.println("Sexo:");
		paciente.setSexo(Character.toLowerCase(buffer.readLine().charAt(0)) == 'f' ? ESexo.F
				: ESexo.M);

		System.out.println("==============================");
		System.out.println("|   Informações do Endereco  |");
		System.out.println("|   Opcional                 |");
		System.out.println("==============================");

		System.out.println("Cidade:");
		endereco.setCidade(buffer.readLine());
		System.out.println("CEP:");
		endereco.setCep(buffer.readLine());
		System.out.println("Bairro:");
		endereco.setBairro(buffer.readLine());
		System.out.println("Endereço:");
		endereco.setEndereco(buffer.readLine());

		System.out.println("==============================");
		System.out.println("|   Informações de Contato   |");
		System.out.println("|   Opcional                 |");
		System.out.println("==============================");

		System.out.println("Telefone:");
		contato.setTelefone(buffer.readLine());
		System.out.println("Celular:");
		contato.setCelular(buffer.readLine());
		System.out.println("Email:");
		contato.setEmail(buffer.readLine());

		paciente.setEndereco(endereco);
		paciente.setContato(contato);

		if (checaDadosPaciente(paciente)) {
			dao.atualizar(paciente);
			System.out
			.println("Paciente cadastrado com sucesso.");

		} else {
			System.out
					.println("Foram encontrados erros no cadastro. Favor  tentar novamente");
		}
		
	}
	
	private static void removerPaciente() throws IOException {
		PacienteDao dao = new PacienteDao();
		List<Paciente> listPaciente = dao.buscaTodos();
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		
		System.out.println("=============================");
		System.out.println("|    Lista dos Pacientes    |");
		System.out.println("=============================");
		
		for (Paciente paciente : listPaciente) {
			System.out.println(paciente.toString());
		}
		
		System.out.println("Informe o ID do Paciente que deseja remover:");
		long idPaciente = Long.parseLong(buffer.readLine());
		
		dao.deletar(idPaciente);	
	}
	
	private static boolean checaDadosPaciente(Paciente paciente) {

		if (paciente.getNome().isEmpty() || paciente.getRg().isEmpty()
				|| paciente.getCpf().isEmpty())
			return false;

		return true;
	}

}
