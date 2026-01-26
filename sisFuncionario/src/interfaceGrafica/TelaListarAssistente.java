package interfaceGrafica;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.ControladorTelaListarAssistente;
import entidade.Assistente;

public class TelaListarAssistente {

	// O metodo é void porque não retorna nenhum valor, ou seja não tem return
	public void listarAtendente(List<Assistente> listaAssistente) {
		
		int quantidadeLinhas = listaAssistente.size();
		
		String [][] tabelaString = new String [quantidadeLinhas][3];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		
		for(Assistente assistente: listaAssistente) {
			
			tabelaString[posicaoLinha][posicaoColuna] = assistente.getCpf();
			posicaoColuna ++;
			tabelaString[posicaoLinha][posicaoColuna] = assistente.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = assistente.getSetor();
			
			posicaoColuna = 0;
			posicaoLinha ++;
		}
		
		String [] nomeColunas = {"CPF", "NOME", "EMAIL"};
		
		JFrame frameListarAssistente = new JFrame();
		frameListarAssistente.setSize(475, 450);
		JPanel panelListarAssistente = new JPanel();
		
		JTable tabelaAssistente = new JTable(tabelaString, nomeColunas);
		tabelaAssistente.setSize(1000,1000);
		tabelaAssistente.setBounds(30,40,300,300);
		
		JScrollPane scrollPaneListarAssistente = new JScrollPane(tabelaAssistente);
		
		JLabel labelCpf = new JLabel("Digite o CPF:");
		panelListarAssistente.add(labelCpf);
		
		JTextField textCpf = new JTextField(10);
		panelListarAssistente.add(textCpf);
		
		JButton botaoDetalhar = new JButton("Detalhar");
		panelListarAssistente.add(botaoDetalhar);
		
		
		panelListarAssistente.add(scrollPaneListarAssistente);
		
		frameListarAssistente.add(panelListarAssistente);
		frameListarAssistente.setLocationRelativeTo(null);
		frameListarAssistente.setVisible(true);
		
		ControladorTelaListarAssistente controladorTelaListarAssistente = new ControladorTelaListarAssistente(textCpf, listaAssistente);
		botaoDetalhar.addActionListener(controladorTelaListarAssistente);
	}
}
