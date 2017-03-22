package folha;

public class Gerente extends Mensalista implements Premiacao {

	public Gerente(String nome, double salario) {
	
		super(nome, salario);
	
	}

	@Override
	public double bonus() {
		
		return getSalario() * 0.05;
	
	}
	
	@Override
	public double salario(){
		return getSalario()+bonus();
	}

	@Override
	public String toString() {
		return "Gerente [bonus()=" + bonus() + ", salario()=" + salario() + ", toString()=" + super.toString() + "]";
	}
	
	

}
