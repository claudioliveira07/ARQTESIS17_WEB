package Aula_02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MinhaClasse2Test {


	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void divisao() {
		assertEquals("Divisão de 10.0/5.0 = 2.0", 2.0, new MinhaClasse2().divisao(10.0,5.0), 0.1); //o último parâmetro é a precisão do resultado (arredondamento)
		assertEquals("Divisão de 1.0/3.0 = 0.33", 0.33, new MinhaClasse2().divisao(1.0,3.0), 0.333);//ou seja só comparará a quantidade de casas e os números informados.
	}
	
	@Test
	public void testDivisaoPorZero(){
		assertEquals("Divisão de 1.0/0.0 = Erro", Double.POSITIVE_INFINITY, new MinhaClasse2().divisao(1.0, 0.0), 0.0);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testErroDivisaoPorZero(){
		assertEquals("Divisão de 1/0 = Erro", 0, new MinhaClasse2().divisao(1, 0));
	}

}
