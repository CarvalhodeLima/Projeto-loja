package menu;

import dao.ProdutoDAO;
import entidades.Produto;
import utils.InputUtils;

public class AdminMenu {

    private ProdutoDAO produtoDAO;

    public AdminMenu(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Remover Produto");
            System.out.println("0. Voltar");

            int opcao = InputUtils.obterInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    removerProduto();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarProduto() {
        String nome = InputUtils.obterString("Nome do produto: ");
        double preco = InputUtils.obterDouble("Preço do produto: ");
        Produto produto = new Produto(nome, preco);
        produtoDAO.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private void listarProdutos() {
        System.out.println("\n=== Lista de Produtos ===");
        for (Produto p : produtoDAO.listarProdutos()) {
            System.out.printf("ID: %d | Nome: %s | Preço: R$ %.2f%n", p.getId(), p.getNome(), p.getPreco());
        }
    }

    private void atualizarProduto() {
        int id = InputUtils.obterInt("ID do produto: ");
        String nome = InputUtils.obterString("Novo nome: ");
        double preco = InputUtils.obterDouble("Novo preço: ");
        Produto produto = new Produto(id, nome, preco);
        produtoDAO.atualizarProduto(produto);
        System.out.println("Produto atualizado.");
    }

    private void removerProduto() {
        int id = InputUtils.obterInt("ID do produto para remover: ");
        produtoDAO.removerProduto(id);
        System.out.println("Produto removido.");
    }
}
