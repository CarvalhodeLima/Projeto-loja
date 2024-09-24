package entidades;
public class Produto{
    private String nome;
    private double preco;
    private int produtoID;
    private int quantidade;

    public Produto(int produtoID, String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.produtoID = produtoID;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    
    public int getProdutoID() {
        return produtoID; 
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    @Override
    public String toString() {
        return "\n  - ID do Produto: " + produtoID +
               "\n  - Nome do Produto: " + nome +
               "\n  - Preço do Produto: $" + preco +
               "\n  - Quantidade em estoque: " + quantidade + 
               "\n";
    }
    
}

