package menu;

import dao.ProdutoDAO;
import utils.InputUtils;

public class ClienteMenu {
    private ProdutoDAO produtoDAO;

    public ClienteMenu(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.println("1. Ver Produtos");
            System.out.println("0. Voltar");

            int opcao = InputUtils.obterInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    verProdutos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void verProdutos() {
        produtoDAO.listarProdutos().forEach(System.out::println);
    }
}
