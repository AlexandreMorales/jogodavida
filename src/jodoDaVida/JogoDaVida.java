package jodoDaVida;

public class JogoDaVida {
	char matriz[][];

	public JogoDaVida() {

		matriz = new char[5][5];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = '0';
			}
		}

		matriz[1][0] = 'X';
		matriz[1][1] = 'X';
		matriz[0][1] = 'X';
		matriz[2][1] = 'X';
	}

	public void mostraMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print("|" + matriz[i][j] + "|");
			}
			System.out.println();
		}
	}

	public void verificaMatriz() {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (isCelulaViva(matriz[i][j])) {
					if (!verificaCelulaVivaNaMatriz(i, j)) {
						matriz[i][j] = '0';
					}
				} else {
					if (verificaCelulaMortaNaMatriz(i, j)) {
						matriz[i][j] = 'X';
					}
				}
			}
		}
	}

	public boolean isCelulaViva(char celula) {
		return celula == 'X';
	}

	public boolean verificaCelulaVivaNaMatriz(int linha, int coluna) {
		int contadorDeCelulas = 0;
		contadorDeCelulas = verificaCelulaNaMatriz(linha, coluna);

		if (contadorDeCelulas < 2) {
			System.out.println("Celula[" + linha + "][" + coluna
					+ "] morreu de baixa população");
			return false;
		}
		if (contadorDeCelulas > 3) {

			System.out.println("Celula[" + linha + "][" + coluna
					+ "] morreu de alta população");
			return false;
		}
		return true;
	}

	public boolean verificaCelulaMortaNaMatriz(int linha, int coluna) {
		int contadorDeCelulas = 0;
		contadorDeCelulas = verificaCelulaNaMatriz(linha, coluna);

		if (contadorDeCelulas == 3) {
			System.out.println("Celula[" + linha + "][" + coluna
					+ "] Reencarnou por população favoravel");
			return true;
		}
		return false;
	}

	public int verificaCelulaNaMatriz(int linha, int coluna) {
		int contadorDeCelulas = 0;
		try {
			if (matriz[linha + 1][coluna] == 'X') {
				contadorDeCelulas++;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			if (matriz[linha + 1][coluna + 1] == 'X') {
				contadorDeCelulas++;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			if (matriz[linha][coluna + 1] == 'X') {
				contadorDeCelulas++;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			if (matriz[linha - 1][coluna + 1] == 'X') {
				contadorDeCelulas++;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			if (matriz[linha - 1][coluna] == 'X') {
				contadorDeCelulas++;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			if (matriz[linha - 1][coluna - 1] == 'X') {
				contadorDeCelulas++;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			if (matriz[linha][coluna - 1] == 'X') {
				contadorDeCelulas++;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			if (matriz[linha - 1][coluna - 1] == 'X') {
				contadorDeCelulas++;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		return contadorDeCelulas;
	}
}
