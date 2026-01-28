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
		Connection connection = null; 
		PreparedStatement preparaOcomandoSQL = null; 
		String comandoSqlInsert = "insert into assistente (nome, cpf, email) values (?, ?, ?)"; 

		try {
			connection = FabricaConexao.criarConexaoSisFuncionario();
			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);
			preparaOcomandoSQL.setString(1, assistente.getNome()); 
			preparaOcomandoSQL.setString(2, assistente.getCpf());
			preparaOcomandoSQL.setString(3, assistente.getEmail()); 
			preparaOcomandoSQL.execute(); 
			salvamento = true; 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Não foi possivel salvar!!!");
		} finally {
			fecharConexoes(connection, preparaOcomandoSQL);
		}
		return salvamento;
	}

	public static List<Assistente> listarAssistenteNoBanco() {
		String comandoSql = "select * from assistente"; 
		Connection connection = null; 
		PreparedStatement prepararOcomandoSql = null;
		List<Assistente> listaAssistente = new ArrayList<Assistente>();
		ResultSet resultadoDaTabelaDoBanco = null;
		try {
			connection = FabricaConexao.criarConexaoSisFuncionario();
			prepararOcomandoSql = connection.prepareStatement(comandoSql);
			resultadoDaTabelaDoBanco = prepararOcomandoSql.executeQuery();
			while (resultadoDaTabelaDoBanco.next()) {
				Assistente assistente = new Assistente();
				assistente.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				assistente.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				assistente.setEmail(resultadoDaTabelaDoBanco.getString("email"));
				listaAssistente.add(assistente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexoes(connection, prepararOcomandoSql);
		}
		return listaAssistente;
	}

	public static boolean deletarAssistente(String cpf) {
		boolean deletar = false;		
		Connection conectar = null;
		PreparedStatement preparedStatement = null;
		String comandoSqlString = "delete from assistente where cpf = ? "; // Ajustado para 'atendente' conforme seu insert

		try {
			conectar = FabricaConexao.criarConexaoSisFuncionario();
			preparedStatement = conectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, cpf);
			preparedStatement.execute();
			deletar = true;			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexoes(conectar, preparedStatement);
		}
		return deletar;	
	}

	public static boolean alterarAssistente(Assistente assistente) {

		Boolean resultadoBoolean = false;
		String comandoSqlString = "UPDATE assistente SET nome = ?,  email = ? WHERE cpf = ?";
		Connection connectar = null;
		PreparedStatement preparedStatement = null;

		try {
			connectar = FabricaConexao.criarConexaoSisFuncionario();

			preparedStatement = connectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, assistente.getNome());
			preparedStatement.setString(2, assistente.getEmail());
			preparedStatement.setString(3, assistente.getCpf());

			preparedStatement.execute();

			resultadoBoolean = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connectar != null) {
					connectar.close();

				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

		return resultadoBoolean;
	}

	private static void fecharConexoes(Connection conn, PreparedStatement ps) {
		try {
			if (conn != null) conn.close();
			if (ps != null) ps.close();
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexão");
		}
	}
}