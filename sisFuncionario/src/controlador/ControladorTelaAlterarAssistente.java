package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import entidade.Assistente;
import interfaceGrafica.TelaListarAssistente;
import repositorio.RepositorioAssistenteImplementacao;

public class ControladorTelaAlterarAssistente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	JFrame frameTelaAlterarAssistente;
	
	TelaListarAssistente telaListarAssistente = new TelaListarAssistente();
	
	RepositorioAssistenteImplementacao assistenteImplementacao = new RepositorioAssistenteImplementacao();
	
	public ControladorTelaAlterarAssistente(JTextField nome, JTextField cpf, JTextField email, JFrame frameTelaAlterarAssistente) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.frameTelaAlterarAssistente = frameTelaAlterarAssistente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ALTERAR": {
			Assistente assistente = new Assistente();
			assistente.setCpf(cpf.getText());
			assistente.setNome(nome.getText());
			assistente.setEmail(email.getText());
			
			assistenteImplementacao.alterarAssistente(assistente);	
		}
		
		case "VOLTAR": {
			frameTelaAlterarAssistente.setVisible(false);
			telaListarAssistente.listarAssistente(assistenteImplementacao.listarAssistente());
		}
		break;
		}
	}
}