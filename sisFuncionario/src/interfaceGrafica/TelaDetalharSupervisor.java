package interfaceGrafica;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidade.Supervisor;

public class TelaDetalharSupervisor {

	
	
	public void detalharGerente(Supervisor supervisor) {
		
		GridLayout grid = new GridLayout(0,2);
		
		JFrame frameTelaSupervisor = new JFrame("Detalhes do Gerente");
		frameTelaSupervisor.setSize(300,180);
		
		JPanel panelTelaSupervisor = new JPanel();
		panelTelaSupervisor.setLayout(grid);
		
		panelTelaSupervisor.add(new JLabel("CPF:"));
		panelTelaSupervisor.add(new JLabel(supervisor.getCpf()));
		
		
		panelTelaSupervisor.add(new JLabel("NOME:"));
		panelTelaSupervisor.add(new JLabel(supervisor.getNome()));
		
		panelTelaSupervisor.add(new JLabel("EMAIL:"));
		panelTelaSupervisor.add(new JLabel(supervisor.getSupervisor()));
		
		frameTelaSupervisor.add(panelTelaSupervisor);
		frameTelaSupervisor.setLocationRelativeTo(null);
		frameTelaSupervisor.setVisible(true);
			
	}
}
