package bancoDados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bancoDados.configuracao.FabricaConexao;
import entidade.Supervisor;

public class DaoSupervisor {

	public static boolean salvarSupervisorNobanco(Supervisor supervisor) {
		boolean salvamento = false;

		
		Connection connection = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL
		String comandoSqlInsert = "insert into supervisor (nome, cpf, email) values (?, ?, ?)"; // Base do comando SQL

		try {
			connection = FabricaConexao.criarConexaoSisFuncionario(); // Recebe o objeto de conexão da																			// classe Fabrica de conex
			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);// Armazena a conexão e o	
			
			preparaOcomandoSQL.setString(1, supervisor.getNome()); // Colocar o valor no campo nome
			preparaOcomandoSQL.setString(2, supervisor.getCpf());// Coloca o valor no campo cpf
			preparaOcomandoSQL.setString(3, supervisor.getEmail()); // Colocar o valor no campo email

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

	public static List<Supervisor> listarSupervisorDoBanco() {
		
		
		Connection connection = null; // Cria o objeto de conexão como null
		PreparedStatement preparaOcomandoSQL = null; // Cria o objeto que prepara o comando SQL

		String comandoSqlInsert = "select * from Supervisor"; // Base do comando SQL
		
		List<Supervisor> listaSupervisor = new ArrayList<Supervisor>();
		
		ResultSet resultadoDaTabelaDoBanco = null;// Armazenar todo o conteudo da consulta no banco
		
		try {
			
			connection = FabricaConexao.criarConexaoSisFuncionario();
			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);
			
			
			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();
			
			while(resultadoDaTabelaDoBanco.next()) {
				
				Supervisor supervisor = new Supervisor();
				
				supervisor.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				supervisor.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				supervisor.setEmail(resultadoDaTabelaDoBanco.getString("email"));
				
				listaSupervisor.add(supervisor);

			}
			
			
		}catch (Exception e) {
			
		
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

		return listaSupervisor;
	}
}
