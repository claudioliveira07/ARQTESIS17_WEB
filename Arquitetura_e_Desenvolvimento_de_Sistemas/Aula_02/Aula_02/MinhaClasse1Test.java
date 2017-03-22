package Aula_02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinhaClasse1Test {
	MinhaClasse1 mc;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSoma(){
		assertEquals("Soma 2 + 2 igual a 4"		, 4, 	new MinhaClasse1().soma(2,2));
		assertEquals("Soma 0 + 1 igual a 1"		, 1,	new MinhaClasse1().soma(0,1));
		assertEquals("Soma -2 + -2 igual a -4"	,-4,	new MinhaClasse1().soma(-2,-2));
		assertEquals("Soma 0 + 0 igual a 0"		, 0, 	new MinhaClasse1().soma(0,0));
	}

}
