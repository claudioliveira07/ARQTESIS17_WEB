package Aula_02;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinhaClasse3Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInverte() {
		int[] entrada 	= {1,2,3};
		int[] esperado 	= {3,2,1};
		
		assertArrayEquals("Vetor inverso de [1,2,3] responde [3,2,1]", new MinhaClasse3().inverte(entrada), esperado);
	}

}
