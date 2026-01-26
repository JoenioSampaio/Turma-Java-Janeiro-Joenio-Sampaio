package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaCadastroAssistente;

//Classe Assistente
public class TelaCadastroAssistente {
	
	public void formularioAssistente(JFrame frameTelaPrincipal) {
		

		String nome = "Digite o nome do assistente:";
		String cpf = "Digite o cpf do atendente:";
		String email = "Digite o email:";
		
		
		JFrame frameCadastroAssistente = new JFrame();
		frameCadastroAssistente.setSize(300,300);
		
		JPanel panelAssistente = new JPanel();
		
		JLabel labelNome = new JLabel(nome);
		panelAssistente.add(labelNome);
		
		JTextField textNome = new JTextField(10);
		panelAssistente.add(textNome);
		
		JLabel labelCpf = new JLabel(cpf);
		panelAssistente.add(labelCpf);
		
		JTextField textCpf = new JTextField(10);
		panelAssistente.add(textCpf);
		
		JLabel labelEmail = new JLabel(email);
		panelAssistente.add(labelEmail);
		
		JTextField textEmail = new JTextField(10);
		panelAssistente.add(textEmail);
		
		JButton botaoCadastrarAssistente = new JButton("Cadastrar");
		panelAssistente.add(botaoCadastrarAssistente);
		
		JButton botaoMenuInicial = new JButton("Menu Inicial");
		panelAssistente.add(botaoMenuInicial);
		
		JButton botaoListar = new JButton("Listar");
		panelAssistente.add(botaoListar);
		
		
		frameCadastroAssistente.add(panelAssistente);
		frameCadastroAssistente.setLocationRelativeTo(null);
		frameCadastroAssistente.setVisible(true);
		
		ControladorTelaCadastroAssistente controladorTelaCadastroAssistente = new ControladorTelaCadastroAssistente(textNome, textCpf, textEmail, frameTelaPrincipal, frameCadastroAssistente );
		botaoCadastrarAssistente.addActionListener(controladorTelaCadastroAssistente);
		botaoMenuInicial.addActionListener(controladorTelaCadastroAssistente);
		botaoListar.addActionListener(controladorTelaCadastroAssistente);
		
		
		
	}

}
