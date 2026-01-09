package codigoFonteBasquete;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entradaDados = new Scanner(System.in);
		JogadorBasquete jogadorBasqueteObjeto = new JogadorBasquete();
		JogadorFutsal jogadorFutsalObjeto = new JogadorFutsal();
		
		
		System.out.println("#############Iniciando##################");
		System.out.println("Cadastro de Atleta: ");
		System.out.println("Digite B para jogador de Basquete ou F para jogador de Futsal");
		String opcao = entradaDados.next();
		
		if(opcao.equals("B")) {
			System.out.println("Digite o nome do Jogador: ");
			jogadorBasqueteObjeto.setNomeAtleta(entradaDados.next());
			
			System.out.println("Digite a idade do Jogador: ");
			jogadorBasqueteObjeto.setIdade(entradaDados.nextInt());
			
			System.out.println("Digite o braço mais forte do Jogador: ");
			jogadorBasqueteObjeto.setBracoMaisForte(entradaDados.next());
			
			System.out.println("Digite o valor por pontos do Jogador: ");
			jogadorBasqueteObjeto.setValorPorPontos(entradaDados.nextDouble());
			
			System.out.println("quantos gols o jogador marcou: ");
			jogadorBasqueteObjeto.setQtdPts(entradaDados.nextInt());
			
			System.out.println("O nome do jogador é: " + jogadorBasqueteObjeto.getNomeAtleta());
			
			System.out.println("A idade do jogador é: " + jogadorBasqueteObjeto.getIdade());
			
			System.out.println("A braço mais forte do jogador é: " + jogadorBasqueteObjeto.getBracoMaisForte());
			
			System.out.println("O valor por ponto marcado é: " + jogadorBasqueteObjeto.getValorPorPontos());
			
			System.out.println("Valor marcado: " + jogadorBasqueteObjeto.calcularPagamento());
			}
		
		
		if(opcao.equals("F")) {
			System.out.println("Digite o nome do Jogador: ");
			jogadorFutsalObjeto.setNomeAtleta(entradaDados.next()); 
			
			System.out.println("Digite a idade do Jogador: ");
			jogadorFutsalObjeto.setIdade(entradaDados.nextInt());
			
			System.out.println("Digite o perna mais forte do Jogador: ");
			jogadorFutsalObjeto.setPernaMaisForte(entradaDados.next()); 
			
			System.out.println("Digite o valor por pontos do Jogador: ");
			jogadorFutsalObjeto.setValorPorGols(entradaDados.nextDouble());
			
			System.out.println("quantos gols o jogador marcou: ");
			jogadorFutsalObjeto.setQtdGol(entradaDados.nextInt());
			
			System.out.println("O nome do jogador é: " + jogadorFutsalObjeto.getNomeAtleta());
			
			System.out.println("A idade do jogador é: " + jogadorFutsalObjeto.getIdade());
			
			System.out.println("A perna mais forte do jogador é: " + jogadorFutsalObjeto.getPernaMaisForte());
			
			System.out.println("O valor por gol marcado é: " + jogadorFutsalObjeto.getValorPorGols());
			
			System.out.println("Valor marcado: " + jogadorFutsalObjeto.calcularPagamento());
			}
		
		System.out.println("#############Fim do Código##################");
	}
}

 