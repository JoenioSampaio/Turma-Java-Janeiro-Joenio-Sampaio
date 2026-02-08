package repository;

import java.util.List;

import model.FuncionarioTerceirizado;



public interface RepositorioFuncionarioTerceirizado {
		
		public  boolean salvarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado); // Assinatura
		
		public List<FuncionarioTerceirizado> funcionarioTerceirizado ();
		
		public boolean alterarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado);
		
		public boolean deletarFuncionarioTerceirizado(String cpf);
	}

