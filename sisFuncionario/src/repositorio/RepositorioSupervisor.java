package repositorio;

import java.util.List;

import entidade.Supervisor;

public  interface RepositorioSupervisor {

	public  boolean salvarSupervisor(Supervisor supervisor); // Assinatura
	public List<Supervisor> listarSupervisor();
	
	
	
}
