package Aula_02;

public class MinhaClasse3 {
	public int[] inverte(int[] v){
		
		int aux[] = new int[v.length];
		
		for(int i = 0 ; i < v.length ; i++){
			aux[v.length-i-1] = v[i];
		}
		
		return aux;
	}
}
