package bancoDados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bancoDados.configuracao.FabricaConexao;
import entidade.Assistente;


public class DaoAssistente {
	
	public static boolean salvarAssistenteNobanco(Assistente assistente) {
		boolean salvamento = false;

		
		Connection connection = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		String comandoSqlInsert = "insert into assistente (nome, cpf, email) values (?, ?, ?)"; // Base do comando SQL

		try {
			connection = FabricaConexao.criarConexaoSisFuncionario(); // Recebe o objeto de conexão da classe Fabrica de conexão

			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);// Armazena a conexão e o comando SQL que vai ser preparado

			preparaOcomandoSQL.setString(1, assistente.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(2, assistente.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(3, assistente.getEmail()); // Colocar o valor no campo email

			preparaOcomandoSQL.execute(); // Executa o comando no banco de dados

			System.out.println("Foi registrado");// Log

			salvamento = true; // Se tudo funcionar certo

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(" Não foi possivel salvar!!!");

		} finally { // Esse é obrigatorio
			try {
				if (connection != null) {
					connection.close();// Se objeto connectionBaseExemplo estiver aberto essa linha vai
													// encerrar
				}
				if (preparaOcomandoSQL != null) {// Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					preparaOcomandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return salvamento;

	}
	
	public static List<Assistente> listarAssistenteNoBanco() {
		
		String comandoSqlInsert = "select * from atendente"; // Comando que será executado
		Connection connection = null; // Objeto de conexão
		PreparedStatement prepararOcomandoSql = null;// Preparação comando
		List<Assistente> listaAssistente = new ArrayList<Assistente>();// a lista que será retornada
		ResultSet resultadoDaTabelaDoBanco = null;// Objeto que recebe a tabela do banco
		
		try {
			
			connection = FabricaConexao.criarConexaoSisFuncionario();// Realiza a conexão
			prepararOcomandoSql = connection.prepareStatement(comandoSqlInsert);//Objeto que possui a conexão e o comando
			resultadoDaTabelaDoBanco = prepararOcomandoSql.executeQuery();// Executa a query no banco
			
			while (resultadoDaTabelaDoBanco.next()) {
				
				Assistente assistente = new Assistente();
				
				assistente.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				assistente.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				assistente.setNome(resultadoDaTabelaDoBanco.getString("email"));

				listaAssistente.add(assistente);
			}
			
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally { // Esse é obrigatorio
			try {
				if (connection != null) {
					connection.close();// Se objeto connectionBaseExemplo estiver aberto essa linha vai
													// encerrar
				}
				if (prepararOcomandoSql != null) {// Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					prepararOcomandoSql.close();
				}
	
			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

	}
		
		
		return listaAssistente;
	}

}
