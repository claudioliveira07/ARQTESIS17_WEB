package Aula_02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	Aluno a1;
	Aluno a2;

	@Before
	public void setUp() throws Exception {
		a1 = new Aluno(123, "Rui");
		a2 = new Aluno(123, "Rui");
	}

	@Test
	public void testAluno() {
		assertEquals("123 RUI igual a 123 Rui", a1, a2);
	}

}
