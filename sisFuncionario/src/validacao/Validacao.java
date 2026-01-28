package validacao;

import entidade.Assistente;
import entidade.Supervisor;

public class Validacao {
	
	public static String validaSupervisor(Supervisor supervisor) {
		String mensangemRetorno = null;
		if(!supervisor.isCpfValido()) {
			mensangemRetorno = "CPF INVALIDO!!!";
		}
		return mensangemRetorno;
	}
	
	public static String validaAssistente(Assistente assistente) {
		String mensangemRetorno = null;
		
		if(!assistente.isCpfValido()) {
			mensangemRetorno = "CPF INVALIDO!!!";
		}
		
		if(assistente.getNome() == null || assistente.getNome().isBlank()) {
			mensangemRetorno = "NOME NÃO PODE SER VAZIO!!!";
		}
		
		if(assistente.getEmail() == null || assistente.getEmail().isBlank()) {
			mensangemRetorno = "E-MAIL NÃO PODE SER VAZIO!!!";
		}
		
		return mensangemRetorno;
	} 
}