package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import entidade.Assistente;
import interfaceGrafica.TelaListarAssistente;
import repositorio.RepositorioAssistenteImplementacao;
import validacao.Validacao;

public class ControladorTelaCadastroAssistente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	JFrame frameTelaPrincipal;
	JFrame frameCadastroAssistente;
	Assistente assistente = new Assistente();
	TelaListarAssistente telaListarAssistente = new TelaListarAssistente();
	RepositorioAssistenteImplementacao repositorioAssistenteImplementacao = new RepositorioAssistenteImplementacao();

	public ControladorTelaCadastroAssistente(JTextField nome, JTextField cpf, JTextField email,
			JFrame frameTelaPrincipal, JFrame frameCadastroAssistente) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.frameTelaPrincipal = frameTelaPrincipal;
		this.frameCadastroAssistente = frameCadastroAssistente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("O botão foi acionado");

		switch (e.getActionCommand()) {
			
			case "Cadastrar": {
	
				assistente.setNome(nome.getText());
				assistente.setCpf(cpf.getText());
				assistente.setEmail(email.getText());
				
				String resultadoValidacao = Validacao.validaAssistente(assistente);
				
				if (resultadoValidacao == null) {
					if (repositorioAssistenteImplementacao.salvarAssistente(assistente)) {
						
						JOptionPane.showMessageDialog(null, "Foi salvo com sucesso!!");
		
						nome.setText(null);
						cpf.setText(null);
						email.setText(null);
		
					} else {
						JOptionPane.showMessageDialog(null, "Não foi salvo com sucesso!!!!!");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, resultadoValidacao);
				}
				break;
	
				}
				case "Menu Inicial": {
					frameCadastroAssistente.setVisible(false);
					frameTelaPrincipal.setVisible(true);
					break;
				}
				case "Listar": {
					frameCadastroAssistente.setVisible(false);
					telaListarAssistente.listarAssistente(repositorioAssistenteImplementacao.listarAssistente());
					break;
				}
		}

	}

}
