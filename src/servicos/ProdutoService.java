package servicos;

import java.util.List;

import entidades.Produto;
import repositorios.ProdutoRepositorio;

public class ProdutoService {

	
    private ProdutoRepositorio repositorio ;    
    
    public ProdutoService(ProdutoRepositorio repositorio) {		 
		this.repositorio = repositorio;
	}

	public void criarProduto(Produto produto) {
		if(validarProduto(produto)){			
			repositorio.salvar(produto);
		}else {
			System.out.println("Produto inválido");
		}
    }

    public void autalizarProduto(Produto produtoExistente, Produto produtoAtualizado) {
        repositorio.atualizar(produtoExistente, produtoAtualizado);
    }

    public void removerProduto(Produto produto) {
        repositorio.remover(produto);
    }

    public void listarTodosProdutos() {
        repositorio.listarTodos();  
    }

    public List<Produto> listarProdutosPorNome(String nome) {
        return repositorio.listarPorNomeProduto(nome);
    }

    public Produto buscarProdutoPorNome(String cpf) {
        return repositorio.buscarPorNome(cpf);
    }
    
    
    //	Validar Produtos
    
    
    private boolean validarProduto(Produto produto) {
    	if(validarNome(produto.getNome()) && 
    			validarPreco(produto.getPreco()) && 
    			validarProdutoID(produto.getProdutoID()) && 
    			validarQuantidade(produto.getQuantidade())
    			) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    private boolean validarNome(String nome) {
    	return nome != null;
    }
    private boolean validarPreco(double preco) {
    	return preco != 0;
    }
    private boolean validarProdutoID(int produtoID){
    	return produtoID != 0;
    }
    private boolean validarQuantidade(int quantidade) {
    	return quantidade != 0;
    }

}