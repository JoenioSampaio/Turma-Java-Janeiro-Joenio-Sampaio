package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import entidade.Assistente;
import interfaceGrafica.TelaAlterarAssistente;
import interfaceGrafica.TelaCadastroAssistente;
import interfaceGrafica.TelaDetalharAssistente;
import interfaceGrafica.TelaListarAssistente;
import interfaceGrafica.TelaPrincipal;
import repositorio.RepositorioAssistenteImplementacao;

public class ControladorTelaListarAssistente implements ActionListener {
	JTextField cpf;
	List<Assistente> listaAssistente;
	JFrame frameListarAssistente;

	RepositorioAssistenteImplementacao repositorioAssistenteImplementacao = new RepositorioAssistenteImplementacao();
	TelaAlterarAssistente telaAlterarAssistente = new TelaAlterarAssistente();
	TelaDetalharAssistente telaDetalharAssistente = new TelaDetalharAssistente();
	TelaCadastroAssistente telaCadastroAssistente = new TelaCadastroAssistente();
	TelaListarAssistente listarAssistente = new TelaListarAssistente();
	TelaPrincipal telaPrincipal = new TelaPrincipal();

	public ControladorTelaListarAssistente(JTextField cpf, List<Assistente> listaAssistente,
			JFrame framelistarAssistente) {
		this.cpf = cpf;
		this.listaAssistente = listaAssistente;
		this.frameListarAssistente = framelistarAssistente;
	}

	@Override
	public void actionPerformed(ActionEvent opcao) {
		switch (opcao.getActionCommand()) {

		case "Detalhar": {
			Assistente assistente = buscarAssistentePorCpf();
			if (assistente != null) {
				telaDetalharAssistente.detalharAssistente(assistente);
			} else {
				JOptionPane.showMessageDialog(null, "CPF INVALIDO!");
			}
			break;
		}

		case "Deletar": {
			Assistente assistente = buscarAssistentePorCpf();
			if (assistente != null) {
				// Deleta do banco
				repositorioAssistenteImplementacao.deletarAssistente(assistente.getCpf());
				JOptionPane.showMessageDialog(null, "DELETADO COM SUCESSO");
				
				// Atualiza a tela
				frameListarAssistente.dispose(); 
				listarAssistente.listarAssistente(repositorioAssistenteImplementacao.listarAssistente());
			} else {
				JOptionPane.showMessageDialog(null, "CPF INVALIDO");
			}
			break;
		}
		
		case "Voltar": { // Verifica seo valor getOpcao é igual a 1
			frameListarAssistente.setVisible(false);
			telaPrincipal.menuPrincipal();

			break;
		}
		

		case "Alterar": {
			Assistente assistente = buscarAssistentePorCpf();
			if (assistente != null) {
				frameListarAssistente.dispose();
				telaAlterarAssistente.alterarAssistente(assistente);
			} else {
				JOptionPane.showMessageDialog(null, "CPF INVALIDO");
			}
			break;
		}
		}
	}

	public Assistente buscarAssistentePorCpf() {
		for (Assistente assistente : listaAssistente) {
			if (assistente.getCpf().equals(cpf.getText())) {
				return assistente;
			}
		}
		return null;
	}
}