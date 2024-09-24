package menu;

import java.util.Scanner;

import entidades.CarrinhoDeCompras;
import entidades.Cliente;
import entidades.Produto;

import repositorios.CarrinhoDeComprasRepositorio;
import repositorios.ClienteRepositorio;
import repositorios.ProdutoRepositorio;
import repositorios.PedidoRepositorio;

import servicos.CarrinhoDeComprasService;
import servicos.ClienteService;
import servicos.ProdutoService;
import servicos.PedidoService;

public class ClienteMenu {
	Scanner scanner = new Scanner(System.in);
	ClienteService clienteService;
    ProdutoService produtoService;
    CarrinhoDeComprasService carrinhoService;
    PedidoService pedidoService;
	ClienteRepositorio clienteRepositorio;
	ProdutoRepositorio produtoRepositorio;
	CarrinhoDeComprasRepositorio carrinhoRepositorio;
	PedidoRepositorio pedidoRepositorio;

    public ClienteMenu(ClienteService clienteService, ProdutoService produtoService,
                       CarrinhoDeComprasService carrinhoService, PedidoService pedidoService,
                       ClienteRepositorio clienteRepositorio,ProdutoRepositorio produtoRepositorio,
                       CarrinhoDeComprasRepositorio carrinhoRepositorio,PedidoRepositorio pedidoRepositorio) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.carrinhoService = carrinhoService;
        this.pedidoService = pedidoService;
        
        this.clienteRepositorio = clienteRepositorio;
        this.produtoRepositorio = produtoRepositorio;
        this.carrinhoRepositorio = carrinhoRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
    }
    
	public void exibirMenu() {
		
		
        Cliente marcelo = new Cliente(1, "Felipe", "000.000.000-01", "felipe@gmail.com", "matriz", "1234");
        clienteService.criarClientes(marcelo);
        
        
		System.out.println(
                "1. Login\n" +
                        "2. Registrar\n" +
                        "3. Voltar ao menu principal"
        );

        int opcaoCliente = scanner.nextInt();

        switch (opcaoCliente) {
            case 1:
                System.out.println("Digite seu email: ");
                String loginEmail = scanner.next();
                System.out.println("Digite sua senha");
                String loginSenha = scanner.next();

                Cliente clienteAutenticado = clienteRepositorio.buscarClientePorEmailESenha(loginEmail, loginSenha);

                if (clienteAutenticado != null) {
                    System.out.println("Logando");

                    CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
                    carrinhoService.criarCarrinho(carrinho);

                    int opcaoCompra;
                    do {

                        System.out.println("Produtos no carrinho: ");
                        carrinhoService.listarProdutosDoCarrinho(carrinho);
                        System.out.println();

                        System.out.println(
                                "1. Listar produtos do Estoque\n" +
                                "2. Adicionar produto ao carrinho\n" +
                                "3. Remover produto do carrinho\n" +
                                "4. Fazer pedido\n"+
                                "5. Sair\n"
                        );

                        opcaoCompra = scanner.nextInt();

                        switch (opcaoCompra) {
                            case 1:
                            	// listar produtos
                            	produtoService.listarTodosProdutos();
                                break;
                            case 2:
                            	// adicionar item ao carrinho
                                System.out.print("Digite o nome do Produto: ");
                                String produtoNomeAdc = scanner.next();
                                Produto produto = produtoService.buscarProdutoPorNome(produtoNomeAdc);
                                carrinhoService.adicionarProdutoAoCarrinho(carrinho, produto);
                                break;
                            case 3:
                                // remover item
                            	System.out.print("Digite o nome do produto que deseja remover: ");
                                String produtoNomeDel = scanner.next();
                                Produto produtoDel = produtoService.buscarProdutoPorNome(produtoNomeDel);
                                carrinhoService.removerProdutoDoCarrinho(carrinho, produtoDel);
                                break;
                            case 4:
                            	// Fazer pedido
                                carrinhoService.listarProdutosDoCarrinho(carrinho);

                                double total = carrinhoService.calcularTotal(carrinho);
                                System.out.println("Valor total do pedido: " + total);

                                System.out.println("Deseja confirmar o pedido? (S/N)");
                                String confirmacaoPedido = scanner.next();

                                if (confirmacaoPedido.equalsIgnoreCase("S")) {
                                    // Criar e registrar o pedido
                                    pedidoService.criarPedido(clienteAutenticado, carrinho);

                                    // Limpar o carrinho após o pedido
                                    carrinhoService.limparCarrinho(carrinho);

                                    System.out.println("Pedido realizado com sucesso!");
                                } else {
                                    System.out.println("Pedido cancelado.");
                                }
                                break;
                            case 5:
                            	break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                    } while (opcaoCompra != 5);
                } else {
                    System.out.println("Credenciais inválidas");
                }

                break;
            case 2: // registrar cliente
                System.out.println("Seja bem-vindo(a)\nDigite seu nome: ");
                String clienteNome = scanner.next();
                System.out.println("Digite seu cpf: (000.000.000-00)");
                String clienteCpf = scanner.next();
                System.out.println("Digite seu email: ");
                String clienteEmail = scanner.next();
                System.out.println("Digite seu endereco: ");
                String clienteEndereco = scanner.next();
                System.out.println("Digite sua senha: ");
                String clienteSenha = scanner.next();

                Cliente cliente = new Cliente(1, clienteNome, clienteCpf, clienteEmail, clienteEndereco, clienteSenha);
                clienteService.criarClientes(cliente);
            break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
	}
}
