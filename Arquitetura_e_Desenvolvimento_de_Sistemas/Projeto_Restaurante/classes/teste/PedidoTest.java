package classes.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import classes.negocio.Pedido;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PedidoTest {

	static Pedido pedido 			= new Pedido();
	static int mesa_teste			=1;
	static int segunda_mesa_teste 	= 1;
	static int id_pedido_teste 		= 0;
	
	//Testa inserção de um pedido
		@BeforeClass		
		public	static	void	method() throws Exception {
			
			acharMesaDeTeste();
			
		}
		
		public static void acharMesaDeTeste(){
			
			System.out.println("Pocurando mesas que atualmente não existem no BD para realizar testes");
			
			//Descobre a primeira mesa que não existe no banco de dados para usar para os teste
			pedido.setMesa(mesa_teste);
			while(pedido.consultarIdPedidoPelaMesa().size() != 0){
				mesa_teste++;
				pedido.setMesa(mesa_teste);
			}
			
			segunda_mesa_teste = mesa_teste+1;
			pedido.setMesa(segunda_mesa_teste);
			while(pedido.consultarIdPedidoPelaMesa().size() != 0){
				segunda_mesa_teste++;
				pedido.setMesa(segunda_mesa_teste);
			}
			System.out.println("As Mesas "+mesa_teste+" e "+segunda_mesa_teste+" foram encontradas e serão utilizadas para os testes.\nImportante: Consulte a aba do JUnit para visualizar os resultados dos testes!\n\n");
			
		}
		

		@Before
		public void tearUp() throws Exception {
			pedido.setMesa(mesa_teste);
			pedido.setId_pedido(id_pedido_teste);
		}

		//***************TESTA INCLUSÃO DE PEDIDO********************
		
		@Test
		public void test001_Cadastro() {
			System.out.println("Pedido - Teste 001 - Cadastrando mesa "+pedido.getMesa());
			assertTrue("Inclusão de pedido com número de mesa: "+mesa_teste+".", pedido.cadastrar());
		}
		
		
		@Test
		public void test002_CadastroMesaNegativa() {
			pedido.setMesa(-1);
			System.out.println("Pedido - Teste 002 - Tentando cadastrar mesa: "+pedido.getMesa());
			assertFalse("Inclusão de pedido com número de mesa (-1).", pedido.cadastrar());
		}
		
		
		@Test
		public void test003_CadastroMesaNula() {
			pedido.setMesa(0);
			System.out.println("Pedido - Teste 003 - Tentando cadastrar mesa: "+pedido.getMesa());
			assertFalse("Inclusão de pedido com número de mesa 0.", pedido.cadastrar());
		}
		
		//***************VERIFICA SE O PEDIDO FOI CRIADO CORRETAMENTE********************
		
		@Test
		public void test004_ConsultaSeOPedidoFoiIncluidoEUnico() {
			System.out.println("Pedido - Teste 004 - Verificando se a o pedido para a mesa "+pedido.getMesa()+" foi registrado e é o único pedido com esta mesa.");
			
			id_pedido_teste = Integer.parseInt(pedido.consultarIdPedidoPelaMesa().get(0));
			
			assertEquals("Verifica se a o pedido para a mesa "+pedido.getMesa()+" foi registrado e é o único pedido com esta mesa.", 7, pedido.consultarIdPedidoPelaMesa().size());

		}
		
		@Test
		public void test005_VerificaSeOPedidoFoiCriadoComStatusAberto(){
			pedido.setId_pedido(id_pedido_teste);
			System.out.println("Pedido - Teste 005 - Verificando se o pedido "+pedido.getId_pedido()+" foi criado com o status aberto");
			assertEquals("Verifica se o pedido aberto está com o status aberto.", "Aberto", pedido.consultar().get(4));
		
		}
		
		@Test
		public void test006_VerificaValorTotalDoPedido(){
			
			System.out.println("Pedido - Teste 006 - Verificando se a query de consulta traz o pedido "+id_pedido_teste+" com valor zero");
			assertEquals("Verifica se a query de consulta traz o pedido "+id_pedido_teste+" com valor zero", "0.0",pedido.consultar().get(6));
			
		}
		
		//***************TESTA MÉTODOS DE ALTERÇÃO E CONSULTA********************
		
		//Testa Status
		@Test
		public void test007_SolicitaTrocaDeStatusParaFechado(){

			System.out.println("Pedido - Teste 007 - Solicitando a troca de status do pedido "+id_pedido_teste+" para fechado");
			assertTrue("Solicitando a troca de status do pedido "+id_pedido_teste+" para fechado", pedido.alterarStatus());
			
		}
		
		@Test
		public void test008_VerificaTrocaDeStatusParaFechado(){
			
			System.out.println("Pedido - Teste 008 - Verifica se a troca de status do pedido "+id_pedido_teste+" para fechado foi de fato realizada");
			assertEquals("Verifica se a troca de status do pedido "+id_pedido_teste+" para fechado foi de fato realizada", "Fechado", pedido.consultar().get(4));
			
		}
		
		@Test
		public void test009_SolicitaTrocaDeStatusParaAberto(){
			
			System.out.println("Pedido - Teste 009 - Solicitando a troca de status do pedido "+id_pedido_teste+" para aberto");
			assertTrue("Solicitando a troca de status do pedido "+id_pedido_teste+" para aberto", pedido.alterarStatus());
			
		}
		
		@Test
		public void test010_VerificaTrocaDeStatusParaAberto(){
			
			System.out.println("Pedido - Teste 010 - Verifica se a troca de status do pedido "+id_pedido_teste+" para aberto foi de fato realizada");
			assertEquals("Verifica se a troca de status do pedido "+id_pedido_teste+" para aberto foi de fato realizada", "Aberto", pedido.consultar().get(4));
			
		}
		
		
		//Testa Mesa
		@Test
		public void test011_SolicitaTrocaDeMesa(){
			
			System.out.println("Pedido - Teste 011 - Solicita troca da mesa "+mesa_teste+" do pedido "+id_pedido_teste+" para a mesa "+segunda_mesa_teste);
			pedido.setMesa(segunda_mesa_teste);
			assertTrue("Pedido - Teste 011 - Solicita troca da mesa "+mesa_teste+" do pedido "+id_pedido_teste+" para a mesa "+segunda_mesa_teste, pedido.alterarMesa());
		}
		
		@Test
		public void test012_VerificaTrocaDeMesa(){
			
			System.out.println("Pedido - Teste 012 - Verifica se a troca da mesa "+mesa_teste+" do pedido "+id_pedido_teste+" para a mesa "+segunda_mesa_teste);
			assertEquals("Verifica se a troca da mesa "+mesa_teste+" do pedido "+id_pedido_teste+" para a mesa "+segunda_mesa_teste, segunda_mesa_teste, Integer.parseInt(pedido.consultar().get(1)));
			
		}
		
		@Test
		public void test013_SolicitaTrocaDeMesa(){
			
			System.out.println("Pedido - Teste 013 - Solicita troca da mesa "+segunda_mesa_teste+" do pedido "+id_pedido_teste+" para a mesa "+mesa_teste);
			pedido.setMesa(mesa_teste);
			assertTrue("Pedido - Teste 011 - Solicita troca da mesa "+segunda_mesa_teste+" do pedido "+id_pedido_teste+" para a mesa "+mesa_teste, pedido.alterarMesa());
		}
		
		@Test
		public void test014_VerificaTrocaDeMesa(){
			
			System.out.println("Pedido - Teste 014 - Verifica se a troca da mesa "+segunda_mesa_teste+" do pedido "+id_pedido_teste+" para a mesa "+mesa_teste);
			assertEquals("Verifica se a troca da mesa "+segunda_mesa_teste+" do pedido "+id_pedido_teste+" para a mesa "+mesa_teste, mesa_teste, Integer.parseInt(pedido.consultar().get(1)));
			
		}


		public static Pedido getPedido() {
			return pedido;
		}


		public static void setPedido(Pedido pedido) {
			PedidoTest.pedido = pedido;
		}


		public static int getMesa_teste() {
			return mesa_teste;
		}


		public static void setMesa_teste(int mesa_teste) {
			PedidoTest.mesa_teste = mesa_teste;
		}


		public static int getId_pedido_teste() {
			return id_pedido_teste;
		}


		public static void setId_pedido_teste(int id_pedido_teste) {
			PedidoTest.id_pedido_teste = id_pedido_teste;
		}

}
