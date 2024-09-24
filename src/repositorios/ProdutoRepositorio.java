package repositorios;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entidades.Produto;

public class ProdutoRepositorio{
	
        private List<Produto> produtos = new ArrayList<>();

        public void salvar(Produto produto) {
            produtos.add(produto);
        }

        public void atualizar(Produto produtoExistente, Produto produtoAtualizado) {
            int index = produtos.indexOf(produtoExistente);
            if (index != -1) {
                produtos.set(index, produtoAtualizado);
            }
        }

        public void remover(Produto produto) {
            produtos.remove(produto);
        }

        public void listarTodos() {
            for (Produto produto : produtos) {
                System.out.println(produto +"\n");
            }
        }

        public List<Produto> listarPorNomeProduto(String nome) {
            return produtos.stream()
                    .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                    .collect(Collectors.toList());
        }
        
        public Produto buscarPorNome(String nome) {
            return produtos.stream()
                .filter(produto -> produto.getNome().equals(nome))
                .findFirst()
                .orElse(null);
        }

}