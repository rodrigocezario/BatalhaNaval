/**
 * Atividade prática em Java
 * Programa "Batalha Naval".
 *
 * @author  Rodrigo Cezario da Silva
 * @version 1.0
 * @since   2015-10-19 
 */
package br.edu.avantis;

import java.util.Scanner;

/*
 * 
	Imagens que deverão utilizada como navios 
	<--> Submarino 4 posições
	<_t_> Destroyer 5 posições 
	<=##=> Cruzador 6 posições 
	<===##> porta-aviões 7 posições 
	Demais imagens 
	~ representa água (ondas do mar) 
	ö representa tiro na água (errou o tiro) 
	?
 * 
 */


public class BatalhaNaval {

	static int mapaQtLinha, mapaQtColuna;

	static char mapa[][];
	static char mapaNavios[][];
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		System.out.printf("\t\t*** BATALHA NAVAL AVANTIS ***\n");
		System.out.printf("\t\t======= Regras do jogo ======\n");
		System.out.println("- O tamanho minimo para o mapa deve de ser 6 x 9");
		System.out.println("- Você deve acertar todos os navios "
				+ "para finalizar o jogo.");
		System.out.println("- O objetivo é acertar todos os "
				+ "navios com o mínimo de tiros possíveis.");
		System.out.println("- Você tem apenas 5 chances de errar.");
		System.out.printf("- Os seguintes navios deverão ser sorteados\n"
				+ "\t 2 - Submarino \t\t <--> \n"
				+ "\t 2 - Destroyer \t\t <_t_> \n"
				+ "\t 1 - Cruzador \t\t <=##=> \n"
				+ "\t 1 - porta-aviões \t <===##> \n\n");
		System.out.printf("\t... Tecle ENTER para continuar ...\n");

		sc.nextLine();

		do {

			System.out.print("Nº. de linha para o mapa: ");

			mapaQtLinha = sc.nextInt();

			System.out.print("Nº. de colunas para o mapa: ");

			mapaQtColuna = sc.nextInt();

		} while ((mapaQtLinha < 6) || (mapaQtColuna < 9));

		mapa = new char[mapaQtLinha][mapaQtColuna];
		mapaNavios = new char[mapaQtLinha][mapaQtColuna];
		System.out.printf("\n\n");// só para ficar visualmente melhor

		for (int i = 0; i < mapaQtLinha; i++) {
			for (int j = 0; j < mapaQtColuna; j++) {
				mapa[i][j] = '~'; // iniciando com ondas
				mapaNavios[i][j] = '~';
			}
		}

		// Preenchimento da matriz com os navios
		criaNavios();
		// Você deverá implementar ainda as seguintes funcionalidades:
		// - Solicitar jogada;
		// - Verificar se a jogada já não foi realizada;
		// - Adicionar (marcar) a jogada (tiro dado) no mapa[][],
		// para isso atribua a posição o símbolo de ? (interrogação)
		// Cabe ainda lembrar que o jogador não pode errar mais que 5 tiros
		imprimeMapa();

	}

	/**
	 * Este método você deve-se implementar a criação dos navios. Utilize a
	 * classe Random para inicializar mapaNavios[][]. Este método deverá ser
	 * chamado uma única vez na inicialização do jogo.
	 */

	public static void criaNavios() {
		// Lembre-se que você deve sortiar aleatóriamente
		// pelo menos 6 navios, sendo:
		//
		// 2 (dois) - Submarino 		<-->
		// 2 (dois) - Destroyer 		<_t_>
		// 1 (um) - Cruzador 			<=##=>
		// 1 (um) - porta-aviões 		<===##>
		//
		// cabe lembrar que a representação
		// gráfica do navio está lado do nome
	}

	/**
	 * Este método imprime Mapa do jogo. Este método deverá ser chamado 
 * toda vez que houver uma jogada.
	 */

	public static void imprimeMapa() {
		// imprimir na tela o mapa[][]
		// imprimi o número da coluna
		for (int i = 0; i < mapaQtColuna; i++) {
			if (i == 0) {
				System.out.printf("  ");
			}
			System.out.printf(" " + (i + 1));
		}
		System.out.printf("\n");
		// imprimi a letra da linha
		for (int i = 0; i < mapaQtLinha; i++) {
			/*
			 * 65 é valor decimal correspondente a letra A maiúscula da tabela
			 * ASCII. A codificação ASCII é usada para representar caracteres
			 * por meio de números, seja decimal, hexadecimal ou octal.
			 */
			System.out.printf(new Character((char) (65 + i)) + " ");
			for (int j = 0; j < mapaQtColuna; j++) {
				if (mapa[i][j] == '?') {
					if (mapaNavios[i][j] != '~') {
						System.out.printf(" " + mapaNavios[i][j]);
					} else {
						System.out.printf(" ö");
					}
				} else {
					System.out.printf(" ~");
				}
			}
			System.out.printf("\n");
		}
	}
}

