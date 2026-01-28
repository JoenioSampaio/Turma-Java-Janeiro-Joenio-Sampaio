package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Supervisor;
import interfaceGrafica.TelaListarSupervisor;
import repositorio.RepositorioSupervisorImplementacao;
import validacao.Validacao;



public class ControladorTelaCadastroSupervisor implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	JFrame frameTelaPrincipal;
	Supervisor supervisor;
	JFrame frameCadastroSupervisor;

	RepositorioSupervisorImplementacao repositorioSupervisorImplementacao = new RepositorioSupervisorImplementacao();
	TelaListarSupervisor telaListarSupervisor = new TelaListarSupervisor();
	
	public ControladorTelaCadastroSupervisor(JTextField nome, JTextField cpf, JTextField email,
			JFrame frameTelaPrincipal, JFrame frameCadastroSupervisor) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.frameTelaPrincipal = frameTelaPrincipal;
		this.frameCadastroSupervisor = frameCadastroSupervisor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
			case "Cadastrar": {
				Supervisor supervisor = new Supervisor();
				supervisor.setNome(nome.getText());
				supervisor.setCpf(cpf.getText());
				supervisor.setEmail(email.getText());
				
				//Pensar em refatorar mais pra frente
				String resultadoValidacao = Validacao.validaSupervisor(supervisor);
				
				if(resultadoValidacao == null) {
					if (repositorioSupervisorImplementacao.salvarSupervisor(supervisor)) {
						
						JOptionPane.showMessageDialog(null, "Foi salvo com sucesso!!");
						nome.setText(null);
						cpf.setText(null);
						email.setText(null);
					} else {
						JOptionPane.showMessageDialog(null, "Não salvo com sucesso!!!!!");
					}
					
				}else {
					JOptionPane.showMessageDialog(null,resultadoValidacao );
				}
	
				
				break;
			}
	
			case "Menu Inicial": {
				frameCadastroSupervisor.setVisible(false);
				frameTelaPrincipal.setVisible(true);
				break;
			}
	
			case "Listar": {
				telaListarSupervisor.listarSupervisor(repositorioSupervisorImplementacao.listarSupervisor());
				break;
			}

		}
	}
}
