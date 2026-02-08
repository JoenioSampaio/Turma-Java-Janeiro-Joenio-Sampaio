package repository;

import java.util.List;


import dao.DaoFuncionarioInterno;
import model.FuncionarioInterno;

public class RepositorioFuncionarioInternoImplementacao implements RepositorioFuncionarioInterno {

	@Override
	public boolean salvarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {
		funcionarioInterno.setNome(colocarEmMaiusculo(funcionarioInterno.getNome()));
		funcionarioInterno.setDataNascimento(colocarEmMaiusculo(funcionarioInterno.getDataNascimento()));
		funcionarioInterno.setCargo(colocarEmMaiusculo(funcionarioInterno.getCargo()));
		funcionarioInterno.setMatricula(colocarEmMaiusculo(funcionarioInterno.getMatricula()));
		funcionarioInterno.setSalario(colocarEmMaiusculo(funcionarioInterno.getSalario()));

		return DaoFuncionarioInterno.salvarFuncionarioInternoNobanco(funcionarioInterno);

	}

	@Override
	public List<FuncionarioInterno> funcionarioInterno() {
		return DaoFuncionarioInterno.listarFuncionarioInternoNoBanco();
	}


	@Override
	public boolean alterarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {
		funcionarioInterno.setNome(colocarEmMaiusculo(funcionarioInterno.getNome()));
		funcionarioInterno.setDataNascimento(colocarEmMaiusculo(funcionarioInterno.getDataNascimento()));
		funcionarioInterno.setCargo(colocarEmMaiusculo(funcionarioInterno.getCargo()));
		funcionarioInterno.setMatricula(colocarEmMaiusculo(funcionarioInterno.getMatricula()));
		funcionarioInterno.setSalario(colocarEmMaiusculo(funcionarioInterno.getSalario()));
		return DaoFuncionarioInterno.alterarFuncionarioInterno(funcionarioInterno);
		
	}

		public String colocarEmMaiusculo (String texto) {
		    return texto.toUpperCase();
		}

		@Override
		public boolean deletarFuncionarioInterno(String cpf) {
			return DaoFuncionarioInterno.deletarFuncionarioInterno(cpf);
		}

}
