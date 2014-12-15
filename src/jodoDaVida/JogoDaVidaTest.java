package jodoDaVida;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
public class JogoDaVidaTest {

	JogoDaVida jogo;
	@Before
	public void setUp(){
		jogo = new JogoDaVida();
	}
	
	@Test
	public void quandoMandarUmaCelulaVivaParaOMetodoIsCelulaVivaRetornaTrue(){
		
		char testaCelula = 'X';
				
		boolean result = jogo.isCelulaViva(testaCelula);
		
		assertThat(result, is(true));
	}
	
	@Test
	public void quandoMandarUmaCelulaMortaParaOMetodoIsCelulaVivaRetornaFalse(){
		
		char testaCelula = '0';
				
		boolean result = jogo.isCelulaViva(testaCelula);
		
		assertThat(result, is(false));
	}
	
	@Test
	public void quandoMandarAPrimeiraPosicaoOMetodoVerificaCelulaNaMatrizRetorna3(){
		zeraMatriz();
		
		int result = jogo.verificaCelulaNaMatriz(0, 0);
		
		assertThat(result, is(3));
		
	}

	public void zeraMatriz(){
		for (int i = 0; i < jogo.matriz.length; i++) {
			for (int j = 0; j < jogo.matriz[0].length; j++) {
				jogo.matriz[i][j] = '0';
			}
		}
		jogo.matriz[1][0] = 'X';
		jogo.matriz[1][1] = 'X';
		jogo.matriz[0][1] = 'X';
		jogo.matriz[2][1] = 'X';
	}
	
}
