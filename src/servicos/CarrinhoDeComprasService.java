package servicos;

import entidades.CarrinhoDeCompras;
import entidades.Produto;
import repositorios.CarrinhoDeComprasRepositorio;

import java.util.List;

public class CarrinhoDeComprasService {

    private CarrinhoDeComprasRepositorio repositorio;

    public CarrinhoDeComprasService(CarrinhoDeComprasRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarCarrinho(CarrinhoDeCompras carrinho) {
        repositorio.salvar(carrinho);
    }

    public void adicionarProdutoAoCarrinho(CarrinhoDeCompras carrinho, Produto produto) {
        carrinho.addProduto(produto);
        repositorio.atualizar(carrinho, carrinho);
    }

    public void removerProdutoDoCarrinho(CarrinhoDeCompras carrinho, Produto produto) {
        carrinho.removerProduto(produto);
        repositorio.atualizar(carrinho, carrinho);
    }

    public void excluirCarrinho(CarrinhoDeCompras carrinho) {
        repositorio.remover(carrinho);
    }
    
    public void limparCarrinho(CarrinhoDeCompras carrinho) {
        carrinho.getProdutos().clear();
    }
    
    public double calcularTotal(CarrinhoDeCompras carrinho) {
        double total = 0.0;

        for (Produto produto : carrinho.getProdutos()) {
            total += produto.getPreco();
        }

        return total;
    }

    public void listarTodosCarrinhos() {
        repositorio.listarTodos();
    }

    public List<Produto> listarProdutosDoCarrinho(CarrinhoDeCompras carrinho) {
        List<Produto> produtosDoCarrinho = carrinho.getProdutos();
        for (Produto produto : produtosDoCarrinho) {
            System.out.println(produto);
        }
        return produtosDoCarrinho;
    }
}
