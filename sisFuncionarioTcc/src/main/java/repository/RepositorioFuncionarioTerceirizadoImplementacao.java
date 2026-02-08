package repository;

import java.util.List;

import dao.DaoFuncionarioInterno;
import dao.DaoFuncionarioTerceirizado;
import model.FuncionarioInterno;
import model.FuncionarioTerceirizado;

public class RepositorioFuncionarioTerceirizadoImplementacao implements RepositorioFuncionarioTerceirizado {

	@Override
	public boolean salvarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado) {
		funcionarioTerceirizado.setNome(colocarEmMaiusculo(funcionarioTerceirizado.getNome()));
		funcionarioTerceirizado.setDataNascimento(colocarEmMaiusculo(funcionarioTerceirizado.getDataNascimento()));
		funcionarioTerceirizado.setFuncao(colocarEmMaiusculo(funcionarioTerceirizado.getFuncao()));
		funcionarioTerceirizado.setEmpresa(colocarEmMaiusculo(funcionarioTerceirizado.getEmpresa()));

		return DaoFuncionarioTerceirizado.salvarFuncionarioTerceirizadoNobanco(funcionarioTerceirizado);

	}

	@Override
	public List<FuncionarioTerceirizado> funcionarioTerceirizado() {
		return DaoFuncionarioTerceirizado.listarFuncionarioTerceirizadoNoBanco();
	}


	@Override
	public boolean alterarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado) {
		funcionarioTerceirizado.setNome(colocarEmMaiusculo(funcionarioTerceirizado.getNome()));
		funcionarioTerceirizado.setDataNascimento(colocarEmMaiusculo(funcionarioTerceirizado.getDataNascimento()));
		funcionarioTerceirizado.setFuncao(colocarEmMaiusculo(funcionarioTerceirizado.getFuncao()));
		funcionarioTerceirizado.setEmpresa(colocarEmMaiusculo(funcionarioTerceirizado.getEmpresa()));
		
		return DaoFuncionarioTerceirizado.alterarFuncionarioTerceirizado(funcionarioTerceirizado);
		
	}

		public String colocarEmMaiusculo (String texto) {
		    return texto.toUpperCase();
		}

		@Override
		public boolean deletarFuncionarioTerceirizado(String cpf) {
			return DaoFuncionarioTerceirizado.deletarFuncionarioTerceirizado(cpf);
		}

}
