package sisAnimal;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	private static String USUARIO = "root"; // O usuario do banco
	private static String SENHA = "root"; // A senha do banco
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/sis_animal?useTimezone=true&serverTimezone=UTC";// URL
																														// DO
																														// BANCO

	public Connection criarConexaoBancoAnimal() {
		
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexao = DriverManager.getConnection(BANCO_URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Não Conectou!!!!");
		}
		

		return conexao;
	}

}
