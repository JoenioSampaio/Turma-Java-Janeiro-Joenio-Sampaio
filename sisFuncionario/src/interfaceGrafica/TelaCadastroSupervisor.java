package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaCadastroSupervisor;


public class TelaCadastroSupervisor {
	
	
	public void formularioSupervisor(JFrame  frameTelaPrincipal) {
		
		String nome = "Digite o nome do supervisor:";
		String cpf = "Digite o cpf do supervisor:";
		String email = "Digite o email:";
		
		JFrame frameCadastroSupervisor = new JFrame();
		frameCadastroSupervisor.setSize(360 , 300);
		
		JPanel panelSupervisor = new JPanel();
		
		
		JLabel labelNome = new JLabel(nome);
		panelSupervisor.add(labelNome);
		
		JTextField textNome = new JTextField(10);
		panelSupervisor.add(textNome);

		JLabel labelCpf = new JLabel(cpf);
		panelSupervisor.add(labelCpf);
		
		JTextField textCpf = new JTextField(10);
		panelSupervisor.add(textCpf);
		
		JLabel labelEmail = new JLabel(email);
		panelSupervisor.add(labelEmail);
		
		JTextField textEmail = new JTextField(10);
		panelSupervisor.add(textEmail);
		
		JButton botaoCadastrarSupervisor = new JButton("Cadastrar");
		panelSupervisor.add(botaoCadastrarSupervisor);
		
		JButton botaoMenuInicial = new JButton("Menu Inicial");
		panelSupervisor.add(botaoMenuInicial);
		
		JButton botaoListar = new JButton("Listar");
		panelSupervisor.add(botaoListar);
		
		frameCadastroSupervisor.add(panelSupervisor);
		frameCadastroSupervisor.setLocationRelativeTo(null); // Centraliza a janela
		frameCadastroSupervisor.setVisible(true);
		
		ControladorTelaCadastroSupervisor controladorTelaCadastroSupervisor = new ControladorTelaCadastroSupervisor(textNome, textCpf, textEmail, frameTelaPrincipal, frameCadastroSupervisor);
		botaoCadastrarSupervisor.addActionListener(controladorTelaCadastroSupervisor);
		botaoMenuInicial.addActionListener(controladorTelaCadastroSupervisor);
		botaoListar.addActionListener(controladorTelaCadastroSupervisor);
		
	}

}
