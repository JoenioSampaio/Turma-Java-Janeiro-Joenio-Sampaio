package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controlador.ControladorTelaCadastroAssistente;

public class TelaCadastroAssistente {
	
	public void formularioAssistente(JFrame frameTelaPrincipal) {
		
		JFrame frameCadastroAssistente = new JFrame("Cadastro de Assistente");
		frameCadastroAssistente.setSize(360,300);
		
		JPanel panelAssistente = new JPanel();
		
		panelAssistente.add(new JLabel("Digite o nome do assistente:"));
		JTextField textNome = new JTextField(15);
		panelAssistente.add(textNome);
		
		panelAssistente.add(new JLabel("Digite o cpf do atendente:"));
		JTextField textCpf = new JTextField(15);
		panelAssistente.add(textCpf);
		
		panelAssistente.add(new JLabel("Digite o email:"));
		JTextField textEmail = new JTextField(15);
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
		
		// Vinculando o controlador
		ControladorTelaCadastroAssistente controlador = new ControladorTelaCadastroAssistente(textNome, textCpf, textEmail, frameTelaPrincipal, frameCadastroAssistente);
		botaoCadastrarAssistente.addActionListener(controlador);
		botaoMenuInicial.addActionListener(controlador);
		botaoListar.addActionListener(controlador);
	}
}