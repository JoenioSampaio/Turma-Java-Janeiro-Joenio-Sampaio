package repositorio;

import java.util.List;

import bancoDados.dao.DaoAssistente;
import entidade.Assistente;


public class RepositorioAssistenteImplementacao implements RepositorioAssistente {

	
	
	@Override
	public boolean salvarAssistente(Assistente assistente) {
		return DaoAssistente.salvarAssistenteNobanco(assistente);
	}

	@Override
	public List<Assistente> listarAssistente() {
		
		return DaoAssistente.listarAssistenteNoBanco();
	}

}
