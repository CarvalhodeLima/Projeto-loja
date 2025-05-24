package entidades;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> itens = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }

    public void removerProduto(Produto produto) {
        if (itens.remove(produto)) {
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }
    }

    public List<Produto> getProdutos() {
        return itens;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            for (Produto p : itens) {
                System.out.println(p);
            }
        }
    }

    public void limpar() {
        itens.clear();
    }
}
