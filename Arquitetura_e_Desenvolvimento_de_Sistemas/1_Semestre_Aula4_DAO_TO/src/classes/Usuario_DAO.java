package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Usuario_DAO {
	Usuario_TO t;
	
	
	public Usuario_DAO() {
		
	}
	
	public Usuario_DAO(Usuario_TO t) {
		this.t = t;
	}
	
	public String criar() {
		try{
			if(t.getNome().equals("") || t.getNome().isEmpty()) {
				return "-1";
			}else if(t.getSenha().equals("") || t.getSenha().isEmpty()) {
				return "-1";
			}else {
				ConexaoBD cbd = new ConexaoBD();
				//Tenta obter conexão
				Connection conexao = cbd.getConexao();
				PreparedStatement st = conexao.prepareStatement("INSERT RESTAURANTE.USUARIO (nome,senha) VALUES ('"+t.getNome()+"' , '"+t.getSenha()+"' );");
				st.execute();
				st.close();
				conexao.close();
				return consultarMaiorID();
			}
		}catch(SQLException sql){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao operar  os dados:\n"+sql.getMessage(),"ERRO AO OPERAR DADOS",0);
			return "-1";
			}
	}
	
	public boolean alterar() {
		try{
			if(t.getNome().equals("") || t.getNome().isEmpty()) {
				return false;
			}else if(t.getSenha().equals("") || t.getSenha().isEmpty()) {
				return false;
			}else {
				ConexaoBD cbd = new ConexaoBD();
				//Tenta obter conexão
				Connection conexao = cbd.getConexao();
				PreparedStatement st = conexao.prepareStatement("UPDATE RESTAURANTE.USUARIO SET nome = '"+t.getNome()+"' , senha = '"+t.getSenha()+"' WHERE id = '"+t.getId()+"';");
				st.execute();
				st.close();
				conexao.close();
				return true;
			}
		}catch(SQLException sql){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao operar  os dados:\n"+sql.getMessage(),"ERRO AO OPERAR DADOS",0);return false;}
	}
	
	public boolean excluir() {
		try{
			if(t.getId().equals("-2")) {
				return false;
			}
			ConexaoBD cbd = new ConexaoBD();
			//Tenta obter conexão
			Connection conexao = cbd.getConexao();
			PreparedStatement st = conexao.prepareStatement("DELETE FROM RESTAURANTE.USUARIO WHERE id = '"+t.getId()+"';");
			st.execute();
			st.close();
			conexao.close();
			return true;
		}catch(SQLException sql){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao operar  os dados:\n"+sql.getMessage(),"ERRO AO OPERAR DADOS",0);return false;}
	}
	
	public ArrayList<Usuario_TO> consultar() {
		try{
			ConexaoBD cbd = new ConexaoBD();
			//Tenta obter conexão
			Connection conexao = cbd.getConexao(); 
			PreparedStatement st = conexao.prepareStatement("SELECT id, nome, senha FROM restaurante.usuario ORDER BY id");
			ResultSet rs = st.executeQuery();
			ArrayList<Usuario_TO> usuarios = new ArrayList<>();
			
			while(rs.next()) {
				Usuario_TO u = new Usuario_TO();
				u.setId(rs.getInt(1)+"");
				u.setNome(rs.getString(2));
				u.setSenha(rs.getString(3));
				usuarios.add(u);
			}
			st.close();
			conexao.close();
			return usuarios;
			
		}catch(SQLException sql){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao operar  os dados:\n"+sql.getMessage(),"ERRO AO OPERAR DADOS",0);
			return new ArrayList<Usuario_TO>();
		}
	
	}
	
	private String consultarMaiorID() {
		try{
			ConexaoBD cbd = new ConexaoBD();
			//Tenta obter conexão
			Connection conexao = cbd.getConexao(); 
			PreparedStatement st = conexao.prepareStatement("SELECT MAX(id) FROM restaurante.usuario");
			ResultSet rs = st.executeQuery();
			rs.next();
			String id = rs.getInt("MAX(id)")+"";
			st.close();
			conexao.close();
			return id;
			
		}catch(SQLException sql){
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao operar  os dados:\n"+sql.getMessage(),"ERRO AO OPERAR DADOS",0);
			return "-1";
		}
	
	}
}




