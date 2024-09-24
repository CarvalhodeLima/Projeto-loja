package entidades;


import java.util.ArrayList;

public class Pedido{
    private int pedidoID;
    private Cliente cliente;
    private String dataPedido;
    private boolean statusPedido;
    
    public Pedido(int pedidoID, Cliente cliente, String dataPedido, boolean statusPedido){
        this.pedidoID = pedidoID;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }
    
    public Pedido(Cliente cliente2, ArrayList<Produto> produtos2, double total) {}

	public int getPedidoID(){
        return this.pedidoID;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public String getDataPedido(){
        return this.dataPedido;
    }
    
    public void setStatusPedido(boolean statusPedido) {
    	this.statusPedido = statusPedido;
    }
    
    public boolean getStatusPedido(){
        return this.statusPedido;
    }
    
    @Override
    public String toString() {
    	return "ID do pedido: "+pedidoID
    			+"\nCliente: "+cliente.getNome()
    			+"\nData do pedido: "+dataPedido
    			+"\nStatus do pedido: "+statusPedido;
    }
}