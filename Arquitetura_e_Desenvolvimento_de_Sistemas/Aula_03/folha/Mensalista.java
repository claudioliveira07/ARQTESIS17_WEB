package folha;

public class Mensalista extends Empregado {
	private double salario;
	
	public Mensalista(String nome, double salario){
		super(nome);
		this.salario = salario;
	}

	@Override
	public double salario() {
		// TODO Auto-generated method stub
		return salario;
	}

	public double getSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return "Mensalista [salario=" + salario + ", salario()=" + salario() + ", toString()=" + super.toString() + "]";
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
