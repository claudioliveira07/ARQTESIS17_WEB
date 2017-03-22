package folha;

import java.util.ArrayList;

public class Teste {
	public static void main (String args[]){
		ArrayList<Empregado> empregados = new ArrayList<>();
		empregados.add(new Mensalista("Joaquim",3000.00));
		empregados.add(new Gerente("Maria",7000.00));
		
		RecursosHumanos rh = new RecursosHumanos();
		
		for(Empregado emp : empregados){
			
			System.out.println(rh.vencimentos(emp));
			
			if( emp instanceof Premiacao){
			
				System.out.println(rh.participacao((Premiacao)emp));
			
			}
		}
	}
}
