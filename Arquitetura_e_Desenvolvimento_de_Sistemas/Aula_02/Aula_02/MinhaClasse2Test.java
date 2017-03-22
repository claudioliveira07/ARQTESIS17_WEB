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
		assertEquals("Divis�o de 10.0/5.0 = 2.0", 2.0, new MinhaClasse2().divisao(10.0,5.0), 0.1); //o �ltimo par�metro � a precis�o do resultado (arredondamento)
		assertEquals("Divis�o de 1.0/3.0 = 0.33", 0.33, new MinhaClasse2().divisao(1.0,3.0), 0.333);//ou seja s� comparar� a quantidade de casas e os n�meros informados.
	}
	
	@Test
	public void testDivisaoPorZero(){
		assertEquals("Divis�o de 1.0/0.0 = Erro", Double.POSITIVE_INFINITY, new MinhaClasse2().divisao(1.0, 0.0), 0.0);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testErroDivisaoPorZero(){
		assertEquals("Divis�o de 1/0 = Erro", 0, new MinhaClasse2().divisao(1, 0));
	}

}
