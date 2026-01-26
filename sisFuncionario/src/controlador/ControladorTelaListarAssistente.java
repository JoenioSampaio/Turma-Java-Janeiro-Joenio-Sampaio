package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTextField;

import entidade.Assistente;
import interfaceGrafica.TelaDetalharAssistente;

public class ControladorTelaListarAssistente implements ActionListener {

	JTextField cpf;
	List<Assistente> listaAssistente;
	
	TelaDetalharAssistente telaDetalharAssistente = new TelaDetalharAssistente();

	public ControladorTelaListarAssistente(JTextField cpf, List<Assistente> listaAssistente) {

		this.cpf = cpf;
		this.listaAssistente = listaAssistente;
	}

	@Override
	public void actionPerformed(ActionEvent opcao) {

		switch (opcao.getActionCommand()) { // Recebe o valor opcao

			case "Detalhar": { // Verifica seo valor getOpcao é igual a 1
				telaDetalharAssistente.detalharAssistente(buscarAssistentePorCpf());
				
	
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
