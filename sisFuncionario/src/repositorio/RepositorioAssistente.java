package repositorio;

import java.util.List;

import entidade.Assistente;


public interface RepositorioAssistente {
	
	public  boolean salvarAssistente(Assistente assistente); // Assinatura
	public List<Assistente> listarAssistente ();
}
