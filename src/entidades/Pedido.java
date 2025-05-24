package entidades;

import java.util.List;

public class Pedido {
    private List<Produto> produtos;
    private double total;

    public Pedido(List<Produto> produtos) {
        this.produtos = produtos;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        double soma = 0;
        for (Produto p : produtos) {
            soma += p.getPreco();
        }
        return soma;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public String toString() {
        return "Pedido com " + produtos.size() + " itens | Total: R$" + total;
    }
}
