package classes.negocio;
import classes.dao.Pedido_DAO;

import java.util.ArrayList;

public class Pedido {

	private int mesa, id_pedido;//id_pedido � auto-increment.
	private String hora_entrada, hora_saida; //A hora de entrada ser� atualizada automaticamente ao inserir o dado no banco, j� a data de sa�da n�o � obrigat�ria.
	private double valor_total; //Ser� atualizado automaticamente ao chamar o m�todo de altera��o.
	private boolean status; // True para pedido fechado/pago e false para pedido aberto.

	public Pedido(){
		setMesa(0);
		setId_pedido(0);
		setValor_total(0.0);
		setStatus(true);
	}
	
	public Pedido(int mesa, int id_pedido, String hora_entrada, String hora_saida, double valor_total, boolean status) {
		super();
		this.mesa = mesa;
		this.id_pedido = id_pedido;
		this.hora_entrada = hora_entrada;
		this.hora_saida = hora_saida;
		this.valor_total = valor_total;
		this.status = status;
	}
	
	public boolean cadastrar(){
		
		if(mesa > 0){
			
			return new Pedido_DAO().cadastrar(mesa); //O m�todo DAO retonar� true quando tudo ocorrer corretamente e false quando houver algum erro.
			
		}

		return false;
		
	}

	public boolean excluir(){
	
		if(id_pedido > 0 && consultar().size() > 0 ){ //Verifica se o id do pedido � maior que zero e se o pedido existe.

			new Pedido_DAO().excluir(id_pedido);
			return true;

		}else{

			return false;			

		}

	}


	//***********************	CONSULTA	***********************

	public ArrayList<String> consultarTudo(){

		return new Pedido_DAO().consultarTudo();		

	}

	public ArrayList<String> consultar(){ //Verifica se o id do pedido � maior que zero e se o pedido existe.

		if(id_pedido > 0){

			return new Pedido_DAO().consultar(id_pedido);		

		}else{

			//A instru��o abaixo retorna um arraylist vazio
			return new ArrayList<String>();

		}

	}
	
	public ArrayList<String> consultarIdPedidoPelaMesa(){ //Verifica se o id do pedido � maior que zero e se o pedido existe.

		if(mesa > 0){

			return new Pedido_DAO().consultarIdPedidoPelaMesa(mesa);		

		}else{

			//A instru��o abaixo retorna um arraylist vazio
			return new ArrayList<String>();

		}

	}


	//***********************	ALTERA��O	***********************

	public boolean alterarHoraSaida(){	//Atualizar� a data e hora atual do pedido e tamb�m passar� o status para false/fechado.
	
		if(id_pedido > 0 && consultar().size() > 0 && consultar().get(4).equals("Aberto")){ //Verifica se o pedido � maior que zero, se ele existe e se o status do pedido � "Aberto".

				new Pedido_DAO().alterarHoraSaida(id_pedido);
				alterarStatus();
				return true;
				
		}else{

			return false;			

		}

	}

	//O M�TODO ABAIXO EST� COMENDADO POR QUE N�O DEVE SER POSS�VEL ALTERAR A HORA DE ENTRADA DO CLIENTE, A HORA DE ENTRADA � SEMPRE A DE ABERTURA DO PEDIDO.
	/*public boolean alterarHoraEntrada(){	//Atualizar� a data e hora atual do pedido
	
		if(id_pedido > 0 && consultar().size() > 0 && consultar().get(4).equals("Aberto")){ //Verifica se o pedido � maior que zero, se ele existe e se o status do pedido � "Aberto".

			new Pedido_DAO().alterarHoraEntrada(id_pedido);
			return true;

		}else{

			return false;			

		}

	}*/

	public boolean alterarMesa(){
	
		if(id_pedido > 0 && mesa > 0 && new Pedido_DAO().consultar(id_pedido).size() > 0){	//Verifica se o n�mero do pedido informado � maior que zero, 
																							//se a mesa informada � maior que zero 
			new Pedido_DAO().alterarMesa(id_pedido, mesa);									//e tamb�m se ele existe no BD.
			return true;

		}else{

			return false;			

		}

	}


	public boolean alterarStatus(){	//Alterar� o status automaticamente, se o status estiver como "True" o banco colocar� como "False", "True" � como se fosse uma pergunta: O pedido est� fechado? (True = Sim), (False = N�o).
	
		if(id_pedido > 0 && new Pedido_DAO().consultar(id_pedido).size() > 0){ //Verifica se o n�mero do pedido informado � maior que zero e tamb�m se ele existe no BD.

			new Pedido_DAO().alterarStatus(id_pedido);
			return true;

		}else{

			return false;			

		}

	}
	

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public String getHora_saida() {
		return hora_saida;
	}

	public void setHora_saida(String hora_saida) {
		this.hora_saida = hora_saida;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Pedido [mesa=" + mesa + ", id_pedido=" + id_pedido + ", hora_entrada=" + hora_entrada + ", hora_saida="
				+ hora_saida + ", valor_total=" + valor_total + ", status=" + status + "]";
	}

}
