package Aula_01_Singleton;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		ArrayList<Aluno> alunos = new ArrayList<>();
		alunos.add(new Aluno("João", 1));
		alunos.add(new Aluno("Maria", 2));
		alunos.add(new Aluno("Joaquim", 3));
		for (Aluno aluno : alunos) {
			System.out.println(aluno + "\n");
		}
	}

} 