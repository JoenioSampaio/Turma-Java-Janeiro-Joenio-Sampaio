package supervisorArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entidade.Assistente;
import entidade.Supervisor;

public class ManipuladorArquivo {

	public boolean registrarSupervisor(Supervisor supervisor) {

		String enderecoArquivo = "C:\\Users\\Windows\\Desktop\\Meus Projetos Impacta\\Turma-Java-Janeiro-Joenio-Sampaio\\sisFuncionario\\Cadastro gerado";

		try {

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));

			bufferedWriter.append("O nome do supervisor é: " + supervisor.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("O cpf do supervisor é:" + supervisor.getCpf());
			bufferedWriter.newLine();
			bufferedWriter.append("O Email do supervisor é: " + supervisor.getEmail());

			bufferedWriter.close();

			return true;

		} catch (IOException e) {
			System.out.println("Erro ao salvar o Supervisor");
			return false;
		}

	}

	public boolean registrarAssistente(Assistente assistente) {

		String enderecoArquivo = "C:\\Users\\Windows\\Desktop\\Meus Projetos Impacta\\Turma-Java-Janeiro-Joenio-Sampaio\\sisFuncionario\\Cadastro gerado";

		try {

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));

			bufferedWriter.append("O nome do assistente é: " + assistente.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("O cpf do assistente é:" + assistente.getCpf());
			bufferedWriter.newLine();
			bufferedWriter.append("O E-mail do assistente é: " + assistente.getEmail());

			bufferedWriter.close();

			return true;

		} catch (IOException e) {
			System.out.println("Erro ao salvar o Assistente");
			return false;
		}

	}

}
