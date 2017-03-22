package Aula_01_Singleton;

public class Aluno {
	private static String nome;
	private static int ra;

	public Aluno(String n, int r) {
		super();
		nome = n;
		ra = r;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", ra=" + ra + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String n) {
		nome = n;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int r) {
		ra = r;
	}
}
