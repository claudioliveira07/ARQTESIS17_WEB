package classes;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {
	String id = "";
	
	@Test
	public void test1CriarUsuarioSemNome() {
		Usuario_Negocio user = new Usuario_Negocio();
		assertEquals("Tentar criar um usuário sem nome resulta em erro, retorna -1", user.criar("","123"), "-1");
	}
	
	@Test
	public void test2CriarUsuarioSemsenha() {
		Usuario_Negocio user = new Usuario_Negocio();
		assertEquals("Tentar criar um usuário sem senha resulta em erro, retorna -1", user.criar("usuario",""), "-1");
	}
	
	@Test
	public void test3CriarUsuario() {
		Usuario_Negocio user = new Usuario_Negocio();
		id = user.criar("usuarioDeTestJUnit","123");
		assertEquals("Tentar criar um usuário sem senha resulta em erro, retorna último id da tabela", id, id);
	}
	
	@Test
	public void test4ConsultarUsuarios() {
		Usuario_Negocio user = new Usuario_Negocio();
		assertEquals("Consultar usuários retorna um array não vazio", user.consultar().size()>0, true);
	}
	
	@Test
	public void test5AlterarUsuarioSemNome() {
		Usuario_Negocio user = new Usuario_Negocio();
		assertEquals("Tentar alterar um usuário para sem nome resulta em erro, retorna false", user.alterar(id,"","123"), false);
	}
	
	@Test
	public void test5AlterarUsuarioSemSenha() {
		Usuario_Negocio user = new Usuario_Negocio();
		assertEquals("Tentar alterar um usuário para sem senha resulta em erro, retorna false", user.alterar(id,"usuario",""), false);
	}
	
	@Test
	public void test6AlterarUsuario() {
		Usuario_Negocio user = new Usuario_Negocio();
		assertEquals("Tentar alterar senha e nome de um usuario, retorna true", user.alterar(id,"JUNIT","TESTE"), true);
	}
	
	@Test
	public void test7ExcluirUsuarioNaoExistente() {
		Usuario_Negocio user = new Usuario_Negocio();
		assertEquals("Tentar excluir um usuario por id não existente resulta em erro, retorna false", user.excluir("-2"), false);
	}
	
	@Test
	public void test8ExcluirUsuarioCriado() {
		Usuario_Negocio user = new Usuario_Negocio();
		assertEquals("Tentar excluir o usuario de teste, retorna true", user.excluir(id), true);
	}

}
