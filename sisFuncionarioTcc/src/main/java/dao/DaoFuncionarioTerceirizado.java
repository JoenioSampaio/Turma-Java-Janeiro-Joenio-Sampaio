package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.FuncionarioTerceirizado;
import util.FabricaConexao;


public class DaoFuncionarioTerceirizado {

	public static boolean salvarFuncionarioTerceirizadoNobanco(FuncionarioTerceirizado funcionarioTerceirizado) {
		boolean salvamento = false;
		Connection connection = null;
		PreparedStatement preparaOcomandoSQL = null;
		String comandoSqlInsert = "insert into funcionarioTerceirizado (cpf, nome, dataNascimento, funcao, empresa) values (?, ?, ?, ?, ?)";

		try {
			connection = FabricaConexao.criarConexaoSisFuncionarioTcc();
			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);
			preparaOcomandoSQL.setString(1, funcionarioTerceirizado.getCpf());
			preparaOcomandoSQL.setString(2, funcionarioTerceirizado.getNome());
			preparaOcomandoSQL.setString(3, funcionarioTerceirizado.getDataNascimento());
			preparaOcomandoSQL.setString(4, funcionarioTerceirizado.getFuncao());
			preparaOcomandoSQL.setString(5, funcionarioTerceirizado.getEmpresa());
			preparaOcomandoSQL.execute();
			salvamento = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Não foi possivel salvar no DaoRepositorioTerceirizado !!!");
		} finally {
			fecharConexoes(connection, preparaOcomandoSQL);
		}
		return salvamento;
	}

	public static List<FuncionarioTerceirizado> listarFuncionarioTerceirizadoNoBanco() {
		String comandoSql = "select * from funcionarioTerceirizado";
		Connection connection = null;
		PreparedStatement prepararOcomandoSql = null;
		
		List<FuncionarioTerceirizado> listaFuncionarioTerceirizado = new ArrayList<FuncionarioTerceirizado>();
		ResultSet resultadoDaTabelaDoBanco = null;
		try {
			connection = FabricaConexao.criarConexaoSisFuncionarioTcc();
			prepararOcomandoSql = connection.prepareStatement(comandoSql);
			resultadoDaTabelaDoBanco = prepararOcomandoSql.executeQuery();
			while (resultadoDaTabelaDoBanco.next()) {
				FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado();
				
				funcionarioTerceirizado.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				funcionarioTerceirizado.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				funcionarioTerceirizado.setDataNascimento(resultadoDaTabelaDoBanco.getString("dataNascimento"));
				funcionarioTerceirizado.setFuncao(resultadoDaTabelaDoBanco.getString("funcao"));
				funcionarioTerceirizado.setEmpresa(resultadoDaTabelaDoBanco.getString("empresa"));
				
				listaFuncionarioTerceirizado.add(funcionarioTerceirizado);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fecharConexoes(connection, prepararOcomandoSql);
		}
		return listaFuncionarioTerceirizado;
	}

	public static boolean deletarFuncionarioTerceirizado(String cpf) {
		boolean deletar = false;
		Connection conectar = null;
		PreparedStatement preparedStatement = null;
		String comandoSqlString = "delete from funcionarioTerceirizado where cpf = ? "; // Ajustado para 'funcionario terceirizado' conforme seu insert

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

	public static boolean alterarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado) {

		Boolean resultadoBoolean = false;
		String comandoSqlString = "UPDATE funcionarioTerceirizado SET cpf = ?,  nome = ?, dataNascimento = ?, fucao = ?, empresa = ?, WHERE cpf = ?";
		Connection connectar = null;
		PreparedStatement preparedStatement = null;

		try {
			connectar = FabricaConexao.criarConexaoSisFuncionarioTcc();

			preparedStatement = connectar.prepareStatement(comandoSqlString);
			preparedStatement.setString(1, funcionarioTerceirizado.getCpf());
			preparedStatement.setString(2, funcionarioTerceirizado.getNome());
			preparedStatement.setString(3, funcionarioTerceirizado.getDataNascimento());
			preparedStatement.setString(4, funcionarioTerceirizado.getFuncao());
			preparedStatement.setString(5, funcionarioTerceirizado.getEmpresa());

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
