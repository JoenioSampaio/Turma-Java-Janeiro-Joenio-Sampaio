package sisAnimal;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DaoAnimal {

	public boolean salvarAnimalBanco(Animal animal) {
		boolean salvamento = false;

		String comandoInsert = "insert into animal (matricula, nome, nomeTutor) values (?, ?, ?)"; // Comando SQl
																											// que sera
																											// executado(o
																											// ponto de
																											// interrogação
																											// representa
																											// os
																											// valores
																											// que ainda
																											// não foi
																											// definidos.

		FabricaConexao fabricaConexao = new FabricaConexao(); // Instancia a fabrica de conexão

		Connection conexao = null;

		PreparedStatement preparacaoComando = null;

		try {

			conexao = fabricaConexao.criarConexaoBancoAnimal(); // Busca a conexão com o Banco de daddos.

			preparacaoComando = conexao.prepareStatement(comandoInsert); // Cria o objeto que gerencia a execução e
																			// ajustes no comando SQL.

			preparacaoComando.setString(1, animal.getMatricula()); // Adiciona a matricula na posição dp primeiro ponto
																	// de ?
			preparacaoComando.setString(2, animal.getNome()); // Adiciona o nome na posição dp segundo ponto de ?
			preparacaoComando.setString(3, animal.getNomeTutor()); // Adiciona o nomeTutor na posição do terceiro ponto
																	// de ?

			preparacaoComando.execute();

			salvamento = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			try {

				if (conexao != null) {
					conexao.close();
				}

				if (preparacaoComando != null) {
					preparacaoComando.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão");
			}
		}

		return salvamento;

	}
}
