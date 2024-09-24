package servicos;

import entidades.Pedido;
import entidades.CarrinhoDeCompras;
import entidades.Cliente;
import repositorios.CarrinhoDeComprasRepositorio;
import repositorios.PedidoRepositorio;
public class PedidoService {
	
	private ClienteService clienteService;
	CarrinhoDeComprasRepositorio carrinhoRepositorio = new CarrinhoDeComprasRepositorio();
	CarrinhoDeComprasService carrinhoService = new CarrinhoDeComprasService(carrinhoRepositorio);
    private PedidoRepositorio repositorio;    

    public PedidoService(PedidoRepositorio repositorio,ClienteService clienteService) { 
		this.repositorio = repositorio;
		this.clienteService = clienteService;
	}

    public void criarPedido(Cliente cliente, CarrinhoDeCompras carrinho) {
        if (clienteService.validarCliente(cliente)) {
            double total = carrinhoService.calcularTotal(carrinho);

            // Criar um novo pedido com base no cliente, produtos no carrinho e o total
            Pedido novoPedido = new Pedido(cliente, carrinho.getProdutos(), total);

            // Salvar o novo pedido no repositório
            repositorio.salvar(novoPedido);

            // Limpar o carrinho após criar o pedido
            carrinhoService.limparCarrinho(carrinho);

            System.out.println("Pedido realizado com sucesso!");
        } else {
            System.out.println("Cliente inválido. Pedido não criado.");
        }
    }


    public void atualizarDenuncia(Pedido pedidoExistente, Pedido pedidoAtualizada) {
        repositorio.atualizar(pedidoExistente,pedidoAtualizada);
    }

    public void removerPedido(Pedido pedido) {
        repositorio.remover(pedido);
    }

    public void listarTodosPedidos() {
        System.out.println("Pedidos: \n");
    	repositorio.listarTodos();
    }
    
    public void listarPorID(int pedidoID) {
         System.out.println(repositorio.listarPorID(pedidoID));
    }
}