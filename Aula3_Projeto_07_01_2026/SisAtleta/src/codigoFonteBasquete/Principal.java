package codigoFonteBasquete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner entradaDados = new Scanner(System.in);

		String opcaoNovoCadastro; // criado e iniciado como null

		List<JogadorFutsal> jogadorFutsal = new ArrayList<JogadorFutsal>();
		List<JogadorBasquete> jogadorBasquetes = new ArrayList<JogadorBasquete>();

		System.out.println("Sistema de cadastro de Atleta");

		do {
			System.out.println("Cadastro de Atleta: ");
			System.out.println("Digite B para jogador de Basquete ou F para jogador de Futsal");

			String opcao = entradaDados.next();

			if (opcao.equals("B")) {
				JogadorBasquete jogadorBasqueteObjeto = new JogadorBasquete();
				System.out.println("Digite o nome do Jogador: ");
				jogadorBasqueteObjeto.setNomeAtleta(entradaDados.next());

				System.out.println("Digite a idade do Jogador: ");
				jogadorBasqueteObjeto.setIdade(entradaDados.nextInt());

				System.out.println("Digite o braço mais forte do Jogador: ");
				jogadorBasqueteObjeto.setBracoMaisForte(entradaDados.next());

				System.out.println("Digite o valor por pontos do Jogador: ");
				jogadorBasqueteObjeto.setValorPorPontos(entradaDados.nextDouble());

				System.out.println("Quantos pontos o jogador marcou: ");
				jogadorBasqueteObjeto.setQtdPts(entradaDados.nextInt());

				jogadorBasqueteObjeto.setSalario(jogadorBasqueteObjeto.calcularPagamento());
				jogadorBasqueteObjeto.setPatrocinio(jogadorBasqueteObjeto.calcularPatrocinio());

				jogadorBasquetes.add(jogadorBasqueteObjeto);

				/*
				 * System.out.println("O nome do jogador é: " +
				 * jogadorBasqueteObjeto.getNomeAtleta());
				 * 
				 * System.out.println("A idade do jogador é: " +
				 * jogadorBasqueteObjeto.getIdade());
				 * 
				 * System.out.println("A braço mais forte do jogador é: " +
				 * jogadorBasqueteObjeto.getBracoMaisForte());
				 * 
				 * System.out.println("O valor por ponto marcado é: " +
				 * jogadorBasqueteObjeto.getValorPorPontos());
				 * 
				 * System.out.println("Valor marcado: " +
				 * jogadorBasqueteObjeto.calcularPagamento());
				 */
			}

			if (opcao.equals("F")) {
				JogadorFutsal jogadorFutsalObjeto = new JogadorFutsal();
				System.out.println("Digite o nome do Jogador: ");
				jogadorFutsalObjeto.setNomeAtleta(entradaDados.next());

				System.out.println("Digite a idade do Jogador: ");
				jogadorFutsalObjeto.setIdade(entradaDados.nextInt());

				System.out.println("Digite o perna mais forte do Jogador: ");
				jogadorFutsalObjeto.setPernaMaisForte(entradaDados.next());

				System.out.println("Digite o valor por pontos do Jogador: ");
				jogadorFutsalObjeto.setValorPorGols(entradaDados.nextDouble());

				System.out.println("Quantos gols o jogador marcou: ");
				jogadorFutsalObjeto.setQtdGol(entradaDados.nextInt());

				jogadorFutsalObjeto.setSalario(jogadorFutsalObjeto.calcularPagamento());
				jogadorFutsalObjeto.setPatrocinio(jogadorFutsalObjeto.calcularPatrocinio());

				jogadorFutsal.add(jogadorFutsalObjeto);

				/*
				 * System.out.println("O nome do jogador é: " +
				 * jogadorFutsalObjeto.getNomeAtleta());
				 * 
				 * System.out.println("A idade do jogador é: " +
				 * jogadorFutsalObjeto.getIdade());
				 * 
				 * System.out.println("A perna mais forte do jogador é: " +
				 * jogadorFutsalObjeto.getPernaMaisForte());
				 * 
				 * System.out.println("O valor por gol marcado é: " +
				 * jogadorFutsalObjeto.getValorPorGols());
				 * 
				 * System.out.println("Valor marcado: " +
				 * jogadorFutsalObjeto.calcularPagamento());
				 */
			}

			System.out.println("Deseja Cadastra mais um (S/N");
			opcaoNovoCadastro = entradaDados.next();

		} while (opcaoNovoCadastro.equals("S"));

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
}
