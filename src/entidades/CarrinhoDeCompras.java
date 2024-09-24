package entidades;
import java.util.ArrayList;
public class CarrinhoDeCompras {
    private int carrinhoID;
    private Cliente cliente;
    private double total;
    private ArrayList<Produto> produtos;
    private boolean finalizado;

    public CarrinhoDeCompras() {
        produtos = new ArrayList<>();
    }
    
    public CarrinhoDeCompras(Cliente cliente) {
    	this.cliente = cliente;
    }

    public int getCarrinhoID() {
        return carrinhoID;
    }

    public void setCarrinhoID(Cliente cliente) {
        this.carrinhoID = cliente.getClienteID();
    }

    public String getClienteNome() {
        return cliente.getNome();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }
    
    public void removerProduto(Produto produto) {
    	produtos.remove(produto);
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
               "carrinhoID= " + carrinhoID +
               ", cliente= " + cliente.getNome() +
               ", total= " + total +
               ", produtos= " + produtos +
               "\n finalizado= " + finalizado +
               '}';
    }


}
