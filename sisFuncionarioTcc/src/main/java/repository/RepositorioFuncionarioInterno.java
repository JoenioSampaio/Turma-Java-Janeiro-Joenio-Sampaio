package repository;

import java.util.List;

import model.FuncionarioInterno;

public interface RepositorioFuncionarioInterno {
		
		public  boolean salvarFuncionarioInterno(FuncionarioInterno funcionarioInterno); // Assinatura
		
		public List<FuncionarioInterno> funcionarioInterno ();
		
		public boolean alterarFuncionarioInterno(FuncionarioInterno funcionarioInterno);
		
		public boolean deletarFuncionarioInterno(String cpf);
	}


