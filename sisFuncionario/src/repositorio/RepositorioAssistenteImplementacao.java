package repositorio;

import java.util.List;
import bancoDados.dao.DaoAssistente;
import entidade.Assistente;

public class RepositorioAssistenteImplementacao implements RepositorioAssistente {
	
	@Override
	public boolean salvarAssistente(Assistente assistente) {
		assistente.setNome(colocarEmMaiusculo(assistente.getNome()));
		assistente.setEmail(colocarEmMaiusculo(assistente.getEmail()));
		return DaoAssistente.salvarAssistenteNobanco(assistente);
	}

	@Override
	public List<Assistente> listarAssistente() {
		return DaoAssistente.listarAssistenteNoBanco();
	}

	@Override
	public boolean alterarAssistente(Assistente assistente) {
		assistente.setNome(colocarEmMaiusculo(assistente.getNome()));
		assistente.setEmail(colocarEmMaiusculo(assistente.getEmail()));
		return DaoAssistente.alterarAssistente(assistente);
	}
	
	public String colocarEmMaiusculo (String texto) {
	    return texto.toUpperCase();
	}

	@Override
	public boolean deletarAssistente(String cpf) {
		return DaoAssistente.deletarAssistente(cpf);
	}	
}