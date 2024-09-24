package menu;

import entidades.Admin;
import entidades.Produto;

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

import java.util.Scanner;

public class AdminMenu {
	
	ClienteService clienteService;
    ProdutoService produtoService;
    CarrinhoDeComprasService carrinhoService;
    PedidoService pedidoService;
    AdminService adminService;
	ClienteRepositorio clienteRepositorio;
	ProdutoRepositorio produtoRepositorio;
	CarrinhoDeComprasRepositorio carrinhoRepositorio;
	PedidoRepositorio pedidoRepositorio;
	AdminRepositorio adminRepositorio;
	
	
	public AdminMenu(ClienteService clienteService, ProdutoService produtoService,
            CarrinhoDeComprasService carrinhoService, PedidoService pedidoService,
            ClienteRepositorio clienteRepositorio,ProdutoRepositorio produtoRepositorio,
            CarrinhoDeComprasRepositorio carrinhoRepositorio,PedidoRepositorio pedidoRepositorio,AdminRepositorio adminRepositorio,AdminService adminService) {
			this.clienteService = clienteService;
			this.produtoService = produtoService;
			this.carrinhoService = carrinhoService;
			this.pedidoService = pedidoService;
			
			this.clienteRepositorio = clienteRepositorio;
			this.produtoRepositorio = produtoRepositorio;
			this.carrinhoRepositorio = carrinhoRepositorio;
			this.pedidoRepositorio = pedidoRepositorio;
			
			this.adminRepositorio = adminRepositorio;
			this.adminService = adminService;
}
    
	int opcaoPrincipal;
	
	Scanner scanner = new Scanner(System.in);
	
	public void exibirMenu() {
        Admin loja = new Admin("admin", "admin");
        adminService.criarAdmin(loja);
        int opcaoAdmin;
		do {
			System.out.println(
                    "1. Login\n" +
                    "2. Registrar\n" +
                    "3. Voltar ao menu principal"
            );

            opcaoAdmin = scanner.nextInt();

            switch (opcaoAdmin) {
                case 1:
                    System.out.println("Digite seu usuario: ");
                    String loginUsuario = scanner.next();
                    System.out.println("Digite sua senha");
                    String loginSenha = scanner.next();

                    Admin adminAutenticado = adminRepositorio.buscarAdminPorUsuarioESenha(loginUsuario, loginSenha);

                    if (adminAutenticado != null) {
                        System.out.println("Logando");

                        int opcaoAdmin2;
                        do { // opcoes do admin
                        	
                            System.out.println();

                            System.out.println(
                                    "1. Listar produtos no Estoque\n" +
                                    "2. Criar produto\n" +
                                    "3. Excluir produto\n" +
                                    "4. Listar Clientes\n"+
                                    "5. Sair\n"
                            );

                            opcaoAdmin2 = scanner.nextInt();

                            switch (opcaoAdmin2) {
                                case 1:
                                	// listar produtos
                                    produtoService.listarTodosProdutos();
                                    break;
                                case 2:
                                	// Criar produto
                                	System.out.println("Digite o id do Produto: ");
                                    int produtoID = scanner.nextInt();
                                	
                                    System.out.println("Digite o nome do Produto: ");
                                    String produtoNome = scanner.next();
                                    
                                    System.out.println("Digite o preco do Produto: ");
                                    double produtoPreco = scanner.nextDouble();
                                    
                                    System.out.println("Digite a quantidade do Produto: ");
                                    int produtoQtd = scanner.nextInt();
                                    Produto produto = new Produto(produtoID, produtoNome, produtoPreco, produtoQtd);
                                    
                                    produtoService.criarProduto(produto);
                                    break;
                                case 3:
                                    // remover item
                                	produtoService.listarTodosProdutos();
                                	System.out.println("Digite o nome do produto quer excluir: ");
                                    String produtoNomeDel = scanner.next();
                                    Produto produtoDel = produtoService.buscarProdutoPorNome(produtoNomeDel);
                                    produtoService.removerProduto(produtoDel);
                                    break;
                                case 4:
                                	//listar clientes
                                	clienteService.listarTodosClientes();
                                break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                            }

                        } while (opcaoAdmin2 != 5);
                    } else {
                        System.out.println("Credenciais inválidas");
                    }
                    break;
                case 2: // registrar admin
                    System.out.println("Seja bem-vindo(a)\n");
                    System.out.println("Digite seu usuario de acesso: ");
                    String adminUsuario = scanner.next();
                    System.out.println("Digite sua senha: ");
                    String adminSenha = scanner.next();

                    Admin admin = new Admin(adminUsuario, adminSenha);
                    adminService.criarAdmin(admin);
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

		}while(opcaoAdmin != 3);
	}
}
