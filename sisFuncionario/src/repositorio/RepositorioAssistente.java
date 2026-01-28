package repositorio;

import java.util.List;

import entidade.Assistente;


public interface RepositorioAssistente {
	
	public  boolean salvarAssistente(Assistente assistente); // Assinatura
	public List<Assistente> listarAssistente ();
	
	public boolean alterarAssistente(Assistente assistente);
	
	public boolean deletarAssistente(String cpf);
}
