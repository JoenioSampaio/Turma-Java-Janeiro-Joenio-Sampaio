package repositorio;

import java.util.List;

import bancoDados.dao.DaoSupervisor;
import entidade.Supervisor;

public class RepositorioSupervisorImplementacao implements RepositorioSupervisor {

	 
	
	@Override
	public boolean salvarSupervisor(Supervisor supervisor) {
		return DaoSupervisor.salvarSupervisorNobanco(supervisor);
	}

	@Override
	public List<Supervisor> listarSupervisor() {
		return DaoSupervisor.listarSupervisorDoBanco();
	}

	

	
	

}
