package classes.negocio;

import classes.dao.Item_Pedido_DAO;

import java.util.ArrayList;

public class Item_Pedido {
	private int id_item_cardapio;	//É utilizado para obter valor e título do item escolhido
	private int id_item_pedido;	//É auto_increment e é um id único, deve ser utilizado para excluir um item de um pedido
	private int id_pedido;	//É premiça para incluir um item pedido, pois o item ficará atrelado ao pedido (FK)
	private int quantidade;

	public Item_Pedido(){
	
		setId_item_cardapio(0);
		setId_item_pedido(0);
		setId_pedido(0);
		setQuantidade(0);

	}
	
	

	public Item_Pedido(int id_item_cardapio, int id_item_pedido, int id_pedido, int quantidade) {
		
		super();
		this.id_item_cardapio = id_item_cardapio;
		this.id_item_pedido = id_item_pedido;
		this.id_pedido = id_pedido;
		this.quantidade = quantidade;
		
	}



	public boolean cadastrar( ){
		
		//AJUSTAR
		Pedido pedido = new Pedido();
		pedido.setId_pedido(getId_pedido());
		ArrayList<String> dados_pedido = pedido.consultar(); //Pega os dados do pedido informado para verificar o status
		
	
		//Item_Cardapio it = new Item_Cardapio();
		//it.setId_item_cardapio(getId_item_cardapio());
		//ArrayList<String> dados_item_cardapio = it.consultar(); //Pega os dados do item de cardapio informado para verificar o status
		
		if(	getId_pedido() 				> 0 && 
			getId_item_cardapio() 		> 0 && 
			getQuantidade() 			> 0 && 
			dados_pedido.size()			> 0 && 					//Verifica se o pedido informado existe
			dados_pedido.get(4)			.equals("Aberto") /* && //Verifica se o status do pedido informado é aberto
			dados_item_cardapio.size()	> 0 && 					//Verifica se o item do cardapio informado existe
			dados_item_cardapio.get(4).equals("Disponível")*/		//Verifica se o status do item cardapio é disponível
		   ){
			
			return new Item_Pedido_DAO().cadastrar(id_pedido, id_item_cardapio, quantidade);
			
		}else{
			
			System.out.println("AA");
			return false;
			
		}
		
	}

	public boolean excluir(){	//A premiça para este método é o id do item pedido, sem ele não é possível realizar a exclusão de um item

		if(id_item_pedido > 0 && consultar().size()>0 && consultar().get(4).equals("Aberto")){//Verifica se o id do item pedido é maior que zero e se o mesmo existe

			return new Item_Pedido_DAO().excluir(id_item_pedido);			

		}else{
			
			return false;
			
		}
	
	}		
	
	public boolean excluirTodosOsItensPedidos( ){	//A premiça para este método é o número do pedido, pois o sistema excluirá todos os itens existentes com aquele pedido como (FK)

		Pedido pedido = new Pedido();
		pedido.setId_pedido(getId_pedido());
		ArrayList<String> dados_pedido = pedido.consultar();
		
		if(id_pedido > 0 && dados_pedido.size() > 0 && dados_pedido.get(4).equals("Aberto")){

			return new Item_Pedido_DAO().excluirTodosOsItensPedidos(id_pedido);			

		}else{
			
			return false;
			
		}
	
	}

	public ArrayList<String> consultar(){

		if(id_item_pedido > 0){
			
			return new Item_Pedido_DAO().consultar(getId_item_pedido());
			
		}else{
			
			return new ArrayList<String>();
			
		}

	}

	
	public ArrayList<String> consultarTodosOsItensPedidosDeUmPedido( ){
		
		Pedido pedido = new Pedido();
		pedido.setId_pedido(getId_pedido());
		
		if(id_pedido > 0 && pedido.consultar().size() > 0){//Verifica se o pedido informado é maior do que zero e também se o mesmo existe

			return new Item_Pedido_DAO().consultarTodosOsItensPedidosDeUmPedido(id_pedido);

		}else{
			
			return new ArrayList<String>();
			
		}

	}

	public boolean alterarQuantidade(){
		
		if(id_item_pedido > 0 && quantidade > 0 && consultar().size() > 0 && consultar().get(5).equals("Aberto")){//Verifica se o item do pedido informado é maior que zero, se a quantidade é maior que zero, se o pedido existe e se o status do pedido é aberto

			return new Item_Pedido_DAO().alterarQuantidade(id_item_pedido, quantidade);			

		}else{
			
			return false;
			
		}

	}

	public boolean alterarIDItemCardapio(){

		//Item_Cardapio item_cardapio = new Item_Cardapio;
		//item_cardapio.setId_item_cardapio(id_item_cardapio);
		if(	id_item_pedido 		> 0 && //Verifica se o item do pedido informado é maior que zero, se existe, se não está fechado, verifica se o item do cardapio informado existe e se está disponível
			consultar().size() 	> 0 && 
			consultar().get(5)	.equals("Aberto")/* &&
			item_cardapio.consultar().size()>0 &&
			item_cardapio.consultar().get(4).equals("Disponível")*/
			){
			
			return new Item_Pedido_DAO().alterarIDItemCardapio(id_item_pedido, id_item_cardapio);			

		}else{
			
			return false;
			
		}
		
	}

	public int getId_item_cardapio() {
		return id_item_cardapio;
	}

	public void setId_item_cardapio(int id_item_cardapio) {
		this.id_item_cardapio = id_item_cardapio;
	}

	public int getId_item_pedido() {
		return id_item_pedido;
	}

	public void setId_item_pedido(int id_item_pedido) {
		this.id_item_pedido = id_item_pedido;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Item_Pedido [id_item_cardapio=" + id_item_cardapio + ", id_item_pedido=" + id_item_pedido
				+ ", id_pedido=" + id_pedido + ", quantidade=" + quantidade + "]";
	}
	
	
}
