package validacao;

import entidade.Supervisor;

public class SupervisorValidacao {
	
	public static String validaSupervisor(Supervisor supervisor) {
		String mensangemRetorno = null;
		if(!supervisor.isCpfValido()) {
			mensangemRetorno = "CPF INVALIDO!!!";
		}
		
		return mensangemRetorno;
		
	}

}
