package supervisorArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entidade.Assistente;
import entidade.Supervisor;

public class ManipuladorArquivo {

	public boolean registrarGerente(Supervisor supervisor) {

		String enderecoArquivo = "C:\\Users\\luciano.pontes\\Desktop\\JavaProgrammer\\Turma-Java-Janeiro\\sisFuncionario\\registroGerente.txt";

		try {

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));

			bufferedWriter.append("O nome do gerente é: " + supervisor.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("O cpf do gerente é:" + supervisor.getCpf());
			bufferedWriter.newLine();
			bufferedWriter.append("O Email do Supervisor é: " + supervisor.getEmail());

			bufferedWriter.close();

			return true;

		} catch (IOException e) {
			System.out.println("Erro ao salvar o Supervisor");
			return false;
		}

	}

	public boolean registrarAtendente(Assistente assistente) {

		String enderecoArquivo = "C:\\\\Users\\\\luciano.pontes\\\\Desktop\\\\JavaProgrammer\\\\Turma-Java-Janeiro\\\\sisFuncionario\\\\registroGerente.txt";

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
