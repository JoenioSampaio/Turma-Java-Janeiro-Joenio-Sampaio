package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import entidade.Supervisor;
import interfaceGrafica.TelaDetalharSupervisor;

public class ControladorTelaListarSupervisor implements ActionListener {

	JTextField textCpf;
	List<Supervisor> listaSupervisor;
	
	TelaDetalharSupervisor telaDetalharSupervisor = new TelaDetalharSupervisor();
	

	public ControladorTelaListarSupervisor(JTextField textCpf, List<Supervisor> listaSupervisor) {
		
		this.textCpf = textCpf;
		this.listaSupervisor = listaSupervisor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		telaDetalharSupervisor.detalharGerente(buscarGerentePorCpf());
		
	}
	
	public Supervisor buscarGerentePorCpf() {
		
		for(Supervisor supervisor: listaSupervisor) {
			if(supervisor.getCpf().equals(textCpf.getText())) {
				return supervisor;
			}
		}
		
		return null;
	}

}
