package classes;

import java.util.ArrayList;

public class Usuario_Negocio {

		public Usuario_Negocio() {
			
		}
		
		public String criar(String nome, String senha) {
			Usuario_TO t = new Usuario_TO();
			t.setNome(nome);
			t.setSenha(senha);
			
			Usuario_DAO d = new Usuario_DAO(t);
			return d.criar();
		}
		
		public boolean alterar(String id, String nome, String senha) {
			Usuario_TO t = new Usuario_TO();
			t.setId(id);
			t.setNome(nome);
			t.setSenha(senha);
			
			Usuario_DAO d = new Usuario_DAO(t);
			return d.alterar();
		}
		
		public boolean excluir(String id) {
			Usuario_TO t = new Usuario_TO();
			t.setId(id);
			
			Usuario_DAO d = new Usuario_DAO(t);
			return d.excluir();
		}
		
		public ArrayList<Usuario_TO> consultar(){
			Usuario_DAO d = new Usuario_DAO();
			return d.consultar();
		}
}
