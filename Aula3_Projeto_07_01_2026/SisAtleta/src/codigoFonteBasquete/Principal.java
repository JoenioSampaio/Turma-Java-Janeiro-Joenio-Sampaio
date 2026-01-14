package codigoFonteBasquete;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String opcaoCadastrarMaisUm; // criado e iniciado como null

		List<JogadorFutsal> jogadorFutsal = new ArrayList<JogadorFutsal>();
		List<JogadorBasquete> jogadorBasquetes = new ArrayList<JogadorBasquete>();

		// Primeira possivel repetição(loop 0 da imagem)
		// JOptionPane é uma classe do java Swing(pacote de interface gratica nativa do
		// java)
		// showInputDialog Ele recebe uma String(via interface grafica) e retorna a
		// String recebido pelo usuario
		
		do {
			String opcaoCadastroAtleta;
			
			boolean letraOuNao;

			do {
				opcaoCadastroAtleta = JOptionPane.showInputDialog("Digite B para Jogador(a) de Basquete ou F para Jogador(a) de Futsal: ");

				letraOuNao = somenteLetras(opcaoCadastroAtleta);

			} while (!letraOuNao);

			
			if (opcaoCadastroAtleta.equals("B")) {
				JogadorBasquete jogadorBasqueteObjeto = new JogadorBasquete();

				/* NOME DO ATLETA */
				do {
					String nome = JOptionPane.showInputDialog("Qual o nome do Jogador(a) de Basquete: ");

					letraOuNao = somenteLetras(nome);

					if (letraOuNao) {
						jogadorBasqueteObjeto.setNomeAtleta(nome);
					}

				} while (!letraOuNao);

				
				/* IDADE DO ATLETA */
				int idadeTemporaria;
				do {
					idadeTemporaria = validaInteiroERetornaInt(
							JOptionPane.showInputDialog("Digite a idade do Jogador: "));
					if (idadeTemporaria != 0) {
						jogadorBasqueteObjeto.setIdade(idadeTemporaria);
					}
				} while (idadeTemporaria == 0);

				
				/* BRAÇO MAIS FORTE */

				do {
					String bracoMaisForte = JOptionPane.showInputDialog("Digite o braço mais forte do Jogador: ");

					letraOuNao = somenteLetras(bracoMaisForte);

					if (letraOuNao) {
						jogadorBasqueteObjeto.setBracoMaisForte(bracoMaisForte);
					}

				} while (!letraOuNao);

				/* VALOR POR PONTOS */
				double valorPorPorPontosTemp;
				do {
					valorPorPorPontosTemp = validaDoubleERetornaDouble(
							JOptionPane.showInputDialog("Digite o valor por ponto marcado $: "));
					if (valorPorPorPontosTemp != 0.0) {
						jogadorBasqueteObjeto.setValorPorPontos(valorPorPorPontosTemp);
					}
				} while (valorPorPorPontosTemp == 0.0);

				/* QUANTIDADE PONTOS */
				int qtdPontoTemporaria;
				do {
					qtdPontoTemporaria = validaInteiroERetornaInt(
							JOptionPane.showInputDialog("Quantos pontos o jogador marcou "));
					if (qtdPontoTemporaria != 0) {
						jogadorBasqueteObjeto.setQtdPts(qtdPontoTemporaria);
					}
				} while (qtdPontoTemporaria == 0);

				/* PAGAMENTO E PATROCINIO */
				jogadorBasqueteObjeto.setSalario(jogadorBasqueteObjeto.calcularPagamento());
				jogadorBasqueteObjeto.setPatrocinio(jogadorBasqueteObjeto.calcularPatrocinio());

				jogadorBasquetes.add(jogadorBasqueteObjeto);
			}

			if (opcaoCadastroAtleta.equals("F")) { 
				JogadorFutsal jogadorFutsalObjeto = new JogadorFutsal();

				/* NOME JOGADOR */
				do {

					String nome = JOptionPane.showInputDialog("Qual o nome do Jogador(a) de Futebol: ");

					letraOuNao = somenteLetras(nome);

					if (letraOuNao) {
						jogadorFutsalObjeto.setNomeAtleta(nome);
					}

				} while (!letraOuNao);

				
				/* IDADE JOGADOR */
				int idadeTemporaria; // variavel para receber o resultado do metodo
				do {
					idadeTemporaria = validaInteiroERetornaInt(JOptionPane.showInputDialog("Digite a idade do Jogador: "));
					if (idadeTemporaria != 0) {
						jogadorFutsalObjeto.setIdade(idadeTemporaria);
					}
				} while (idadeTemporaria == 0);

				
				/* PERNA MAIS FORTE */
				do {
					String pernaMaisForte = JOptionPane.showInputDialog("Digite o perna mais forte do Jogador: ");

					letraOuNao = somenteLetras(pernaMaisForte);

					if (letraOuNao) {
						jogadorFutsalObjeto.setPernaMaisForte(pernaMaisForte);
					}

				} while (!letraOuNao);
				
			
				/* VALOR POR GOL */
				double valorPorGolTemp;
				do {
					valorPorGolTemp = validaDoubleERetornaDouble(
							JOptionPane.showInputDialog("Digite o valor por gol marcado $: "));
					if (valorPorGolTemp != 0.0) {
						jogadorFutsalObjeto.setValorPorGols(valorPorGolTemp);
					}

				} while (valorPorGolTemp == 0.0);

				/* QUANDTIDADE DE GOL */
				int qtdGolTemporaria;
				do {
					qtdGolTemporaria = validaInteiroERetornaInt(JOptionPane.showInputDialog("Quantos gols o jogador marcou: "));
					
					if (qtdGolTemporaria != 0) {
						jogadorFutsalObjeto.setQtdGol(qtdGolTemporaria);
					}
					
				} while (qtdGolTemporaria == 0);

				
				/* PAGAMENTE E PATROCIONIO */
				jogadorFutsalObjeto.setSalario(jogadorFutsalObjeto.calcularPagamento());
				jogadorFutsalObjeto.setPatrocinio(jogadorFutsalObjeto.calcularPatrocinio());

				jogadorFutsal.add(jogadorFutsalObjeto);
			}

			opcaoCadastrarMaisUm = JOptionPane.showInputDialog("Deseja Cadastra mais um (S/N");

		} while (opcaoCadastrarMaisUm.equals("S"));

		System.out.println("############Lista de jogadores de Futsal cadastrados############");

		for (JogadorFutsal jogadorFutsalLista : jogadorFutsal) {
			System.out.println("nome: " + jogadorFutsalLista.getNomeAtleta());
			System.out.println("idade: " + jogadorFutsalLista.getIdade());
			System.out.println("perna mais forte: " + jogadorFutsalLista.getPernaMaisForte());
			System.out.println("Valor recebido por Gol: " + jogadorFutsalLista.getValorPorGols());
			System.out.println("Quantidade de Gol: " + jogadorFutsalLista.getQtdGol());
			System.out.println("Valor salario: " + jogadorFutsalLista.getSalario());
			System.out.println("O valor do patrocinio é: " + jogadorFutsalLista.getPatrocinio());

			System.out.println("_____________________________________________________________________");
		}

		System.out.println("############Lista de jogadores de Basquete cadastrados############");

		for (JogadorBasquete jogadorBasqueteLista : jogadorBasquetes) {
			System.out.println("nome: " + jogadorBasqueteLista.getNomeAtleta());
			System.out.println("idade: " + jogadorBasqueteLista.getIdade());
			System.out.println("perna mais forte: " + jogadorBasqueteLista.getBracoMaisForte());
			System.out.println("Valor recebido por Gol: " + jogadorBasqueteLista.getValorPorPontos());
			System.out.println("Quantidade de Gol: " + jogadorBasqueteLista.getQtdPts());
			System.out.println("Valor salario: " + jogadorBasqueteLista.getSalario());
			System.out.println("O valor do patrocinio é: " + jogadorBasqueteLista.getPatrocinio());

			System.out.println("_____________________________________________________________________");
		}

		System.out.println("#######Encerrado#######");
	}

	// Recebe a string valida e retorna o numero inteiro.
	public static int validaInteiroERetornaInt(String numeroString) {
		int numeroInteiro = 0;

		if (numeroString == null || numeroString.isBlank()) {
			JOptionPane.showMessageDialog(null, "Valor inválido");
		} else {
			try {
				numeroInteiro = Integer.parseInt(numeroString);

				// so vai cair o Catch se não conseguir converter o numeroString em inteiro.
			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Apenas numeros."); // comunica para o usuario
				System.out.println("O valor: " + e.getMessage() + "Não pode ser convertido para inteiro"); // dev
			}
		}
		return numeroInteiro;
	}

	/* VALIDA OPCOES */
	public static Double validaDoubleERetornaDouble(String numeroString) {
		Double numeroDecimal = 0.0;

		if (numeroString == null || numeroString.isBlank()) {
			JOptionPane.showMessageDialog(null, "Valor inválido");
		} else {
			try {
				numeroDecimal = Double.parseDouble(numeroString);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Apenas numeros."); // comunica para o usuario
				System.out.println("O valor: " + e.getMessage() + "Não pode ser convertido para inteiro");
			}
		}
		return numeroDecimal;
	}

	// Esse metodo retorna verdadeiro se a String tiver apenas letras
	public static boolean somenteLetras(String texto) {
			
			if(texto == null || texto.isBlank()) {
				JOptionPane.showMessageDialog(null,"Inválido!");
				return false;
			}
			//for(tradicional)
			//texto.length() -> Conta quantos caracteres tem na String
			//int indice = 0 -> Indica que o indice começa na posição 0
			//indice++ -> Vai incrementar mais uma posição no valor de indice
			// Character.isLetter Retorna verdadeiro se o Char for uma letra e falso se não for
			//charAt recebe um inteiro e retona o Char de acordo com a posição enviada.
			//! -> O is isLetter retorna verdadeiro, ele inverte a logica do IF para que o metodo não retorne falso
			
			int qtdCaracterString = texto.length();
			
			for(int indice = 0; indice < qtdCaracterString; indice++) {
				
				char caracterAtual = texto.charAt(indice);
				
				if(!Character.isLetter(caracterAtual)) {
					JOptionPane.showMessageDialog(null, "Somente Letras;");
					return false;
					
				}
				
			}
			return true;
	}
}

