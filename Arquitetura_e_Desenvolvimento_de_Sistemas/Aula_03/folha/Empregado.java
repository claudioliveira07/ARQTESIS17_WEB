package folha;

public abstract class Empregado {
	private String nome;

	public String getNome() {
		return nome;
	}
	
	public abstract double salario();


	public void setNome(String nome) {
		this.nome = nome;
	}

	public Empregado(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Empregado [nome=" + nome + ", salario()=" + salario() + "]";
	}
}
