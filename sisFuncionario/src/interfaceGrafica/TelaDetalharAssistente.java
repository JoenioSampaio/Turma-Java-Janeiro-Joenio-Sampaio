package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidade.Assistente;


public class TelaDetalharAssistente {
	
public void detalharAssistente(Assistente assistente) {
		
		GridLayout grid = new GridLayout(0,2);
		
		JFrame frameTelaAssistente = new JFrame("Detalhes do Assistente");
		frameTelaAssistente.setSize(300,180);
		
		JPanel panelTelaAssistente = new JPanel();
		panelTelaAssistente.setLayout(grid);
		
		panelTelaAssistente.add(new JLabel("CPF:"));
		panelTelaAssistente.add(new JLabel(assistente.getCpf()));
		
		
		panelTelaAssistente.add(new JLabel("NOME:"));
		panelTelaAssistente.add(new JLabel(assistente.getNome()));
		
		panelTelaAssistente.add(new JLabel("SETOR:"));
		panelTelaAssistente.add(new JLabel(assistente.getEmail()));
		
		frameTelaAssistente.add(panelTelaAssistente);
		frameTelaAssistente.setLocationRelativeTo(null);
		frameTelaAssistente.setVisible(true);
		
	}
}
