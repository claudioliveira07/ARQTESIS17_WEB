package folha;

public class RecursosHumanos {

	
	public RecursosHumanos() {
		
	}
	
	public double vencimentos(Empregado emp){
		return emp.salario();
	}
	
	public double participacao(Premiacao premio){
		return premio.bonus();
	}

}
