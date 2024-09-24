package entidades;

import java.util.Scanner; 

import menu.AdminMenu;
import menu.ClienteMenu;
import repositorios.AdminRepositorio;
import repositorios.CarrinhoDeComprasRepositorio;
import repositorios.ClienteRepositorio;
import repositorios.PedidoRepositorio;
import repositorios.ProdutoRepositorio;
import servicos.AdminService;
import servicos.CarrinhoDeComprasService;
import servicos.ClienteService;
import servicos.PedidoService;
import servicos.ProdutoService;

public class Main {
    public static void main(String[] args) {
        // objetos de repositorio e servicos
    	
		ClienteRepositorio clienteRepositorio = new  ClienteRepositorio();
		ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();
		CarrinhoDeComprasRepositorio carrinhoRepositorio = new CarrinhoDeComprasRepositorio();
		PedidoRepositorio pedidoRepositorio = new PedidoRepositorio();
		AdminRepositorio adminRepositorio = new AdminRepositorio();

    	ProdutoService produtoService = new ProdutoService(produtoRepositorio);
    	ClienteService clienteService = new ClienteService(clienteRepositorio);
    	CarrinhoDeComprasService carrinhoService = new CarrinhoDeComprasService(carrinhoRepositorio);
    	PedidoService pedidoService = new PedidoService(pedidoRepositorio, clienteService);
    	AdminService adminService = new AdminService(adminRepositorio);

    	ClienteMenu clienteMenu = new ClienteMenu(clienteService, produtoService, carrinhoService, pedidoService,clienteRepositorio,produtoRepositorio,carrinhoRepositorio,pedidoRepositorio);
    	AdminMenu adminMenu = new AdminMenu(clienteService, produtoService, carrinhoService, pedidoService,clienteRepositorio,produtoRepositorio,carrinhoRepositorio,pedidoRepositorio,adminRepositorio,adminService);

        Produto produto1 = new Produto(1,"Celular", 900.0,1);
        produtoService.criarProduto(produto1);
        Produto produto2 = new Produto(2,"Computador", 2000.0,2);
        produtoService.criarProduto(produto2);
        Produto produto3 = new Produto(3,"Monitor", 3500.0,5);
        produtoService.criarProduto(produto3);


        Scanner scanner = new Scanner(System.in);

        int opcaoPrincipal;

        do {
            System.out.println(
                    " \n" +
                    "ACESSANDO O ESTOQUE ! SELECIONE UMA OPÇÃO: \n" +
                    "1. Usuário\n" +
                    "2. ADM\n" +
                    "3. Sair"
            );
            
            opcaoPrincipal = scanner.nextInt();

        switch (opcaoPrincipal) {
                     case 1:
                         clienteMenu.exibirMenu();
                         break;
                     case 2:
                         adminMenu.exibirMenu();
                         break;
                     case 3:
                         System.out.println("Finalizando serviço");
                         break;
                     default:
                         System.out.println("Erro! Tente novamente.");

                 }

        } while (opcaoPrincipal != 3);

        scanner.close();
    }
}
