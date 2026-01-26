package interfaceGrafica;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.ControladorTelaListarSupervisor;
import entidade.Supervisor;

public class TelaListarSupervisor {
	
	
	public void listarSupervisor(List<Supervisor> listaSupervisor) {
		
		
		int quantidadeLinhas = listaSupervisor.size();
		
		String [][] tabelaString = new String [quantidadeLinhas][3];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		
		for(Supervisor gerente: listaSupervisor) {
			
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna ++;
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getEmail();
			
			posicaoColuna = 0;
			posicaoLinha ++;
		}
		
		String [] nomeColunas = {"CPF", "NOME", "EMAIL"};
		
		JFrame frameListarsupervisor = new JFrame();
		frameListarsupervisor.setSize(475, 450);
		
		JTable tabelaSupervisor = new JTable(tabelaString, nomeColunas);
		tabelaSupervisor.setSize(1000,1000);
		tabelaSupervisor.setBounds(30,40,300,300);
		
		JPanel panelListarSupervisor = new JPanel();
		
		
		
		JScrollPane scrollPaneListarSupervisor = new JScrollPane(tabelaSupervisor);
		
		JLabel labelCpf = new JLabel("Digite o CPF");
		panelListarSupervisor.add(labelCpf);
		
		JTextField textCpf = new JTextField(10);
		panelListarSupervisor.add(textCpf);
		
		JButton botaoDetalhar = new JButton("Detalhar");
		panelListarSupervisor.add(botaoDetalhar);
		
		panelListarSupervisor.add(scrollPaneListarSupervisor);
		
		
		frameListarsupervisor.add(panelListarSupervisor);
		frameListarsupervisor.setLocationRelativeTo(null);
		frameListarsupervisor.setVisible(true);
		
		ControladorTelaListarSupervisor controladorTelaListar = new ControladorTelaListarSupervisor(textCpf, listaSupervisor);
		botaoDetalhar.addActionListener(controladorTelaListar);
		
		
		
		
		
	}

}
