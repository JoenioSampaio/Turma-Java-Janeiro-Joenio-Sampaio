package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.FuncionarioInterno;
import util.FabricaConexao;


public class DaoFuncionarioInterno {

	public static boolean salvarFuncionarioInternoNobanco(FuncionarioInterno funcionarioInterno) {
		boolean salvamento = false;
		Connection connection = null;
		PreparedStatement preparaOcomandoSQL = null;
		String comandoSqlInsert = "insert into funcionarioInterno (cpf, nome, dataNascimento, cargo, matricula, salario) values (?, ?, ?, ?, ?, ?)";

		try {
			connection = FabricaConexao.criarConexaoSisFuncionarioTcc();
			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);
			preparaOcomandoSQL.setString(1, funcionarioInterno.getCpf());
			preparaOcomandoSQL.setString(2, funcionarioInterno.getNome());
			preparaOcomandoSQL.setString(3, funcionarioInterno.getDataNascimento());
			preparaOcomandoSQL.setString(4, funcionarioInterno.getCargo());
			preparaOcomandoSQL.setString(5, funcionarioInterno.getMatricula());
			preparaOcomandoSQL.setString(6, funcionarioInterno.getSalario());
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

	public static List<FuncionarioInterno> listarFuncionarioInternoNoBanco() {
		String comandoSql = "select * from funcionarioInterno";
		Connection connection = null;
		PreparedStatement prepararOcomandoSql = null;
		List<FuncionarioInterno> listaFuncionarioInterno = new ArrayList<FuncionarioInterno>();
		ResultSet resultadoDaTabelaDoBanco = null;
		try {
			connection = FabricaConexao.criarConexaoSisFuncionarioTcc();
			prepararOcomandoSql = connection.prepareStatement(comandoSql);
			resultadoDaTabelaDoBanco = prepararOcomandoSql.executeQuery();
			while (resultadoDaTabelaDoBanco.next()) {
				FuncionarioInterno funcionarioInterno = new FuncionarioInterno();
				
				funcionarioInterno.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				funcionarioInterno.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				funcionarioInterno.setDataNascimento(resultadoDaTabelaDoBanco.getString("dataNascimento"));
				funcionarioInterno.setCargo(resultadoDaTabelaDoBanco.getString("cargo"));
				funcionarioInterno.setCargo(resultadoDaTabelaDoBanco.getString("matricula"));
				funcionarioInterno.setSalario(resultadoDaTabelaDoBanco.getString("salario"));
				
				
				
				listaFuncionarioInterno.add(funcionarioInterno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexoes(connection, prepararOcomandoSql);
		}
		return listaFuncionarioInterno;
	}

	public static boolean deletarFuncionarioInterno(String cpf) {
		boolean deletar = false;
		Connection conectar = null;
		PreparedStatement preparedStatement = null;
		String comandoSqlString = "delete from funcionarioInterno where cpf = ? "; // Ajustado para 'funcionario interno' conforme seu insert

		try {
			conectar = FabricaConexao.criarConexaoSisFuncionarioTcc();
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

	public static boolean alterarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {

		Boolean resultadoBoolean = false;
		String comandoSqlString = "UPDATE funcionarioInterno SET cpf = ?,  nome = ?, dataNascimento = ?, cargo = ?, matricula = ?, salario = ? WHERE cpf = ?";
		Connection connectar = null;
		PreparedStatement preparedStatement = null;

		try {
			connectar = FabricaConexao.criarConexaoSisFuncionarioTcc();

			preparedStatement = connectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, funcionarioInterno.getCpf());
			preparedStatement.setString(2, funcionarioInterno.getNome());
			preparedStatement.setString(3, funcionarioInterno.getDataNascimento());
			preparedStatement.setString(4, funcionarioInterno.getCargo());
			preparedStatement.setString(5, funcionarioInterno.getMatricula());
			preparedStatement.setString(6, funcionarioInterno.getSalario());

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
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexão");
		}
	}
}