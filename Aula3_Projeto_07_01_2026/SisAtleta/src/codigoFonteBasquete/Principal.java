package codigoFonteBasquete;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("#############Iniciando##################");
		Scanner entradaDados = new Scanner(System.in);
		JogadorBasquete jogadorBasqueteObjeto = new JogadorBasquete();
		JogadorFutsal  jogadorFutsalObjeto = new JogadorFutsal();
		
		
		
		System.out.println("Cadastro de Atleta: ");
		System.out.println("Digite B para jogador de Basquete ou F para jogador de Futsal");
		String opcao = entradaDados.next();
		
		if(opcao.equals("B")) {
			System.out.println("Qual o nome do Jogador: ");
			jogadorBasqueteObjeto.nomeAtleta = entradaDados.next();
			
			System.out.println("Qual a idade do Jogador: ");
			jogadorBasqueteObjeto.idade = entradaDados.nextInt();
			
			System.out.println("Qual o braço mais forte do Jogador: ");
			jogadorBasqueteObjeto.BracoMaisForte = entradaDados.next();
			
			System.out.println("Qual o valor por pontos do Jogador: ");
			jogadorBasqueteObjeto.ValorPorPontos = entradaDados.nextDouble();
			}
		
		if(opcao.equals("F")) {
			System.out.println("Qual o nome do Jogador: ");
			jogadorFutsalObjeto.nomeAtleta = entradaDados.next();
			
			System.out.println("Qual a idade do Jogador: ");
			jogadorFutsalObjeto.idade = entradaDados.nextInt();
			
			System.out.println("Qual o perna mais forte do Jogador: ");
			jogadorFutsalObjeto.PernaMaisForte = entradaDados.next();
			
			System.out.println("Qual o valor por pontos do Jogador: ");
			jogadorFutsalObjeto.ValorPorGols = entradaDados.nextDouble();
			}
		
		System.out.println("#############Fim##################");
	}
}
