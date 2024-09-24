package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import entidades.Pedido;

public class PedidoRepositorio{

    private List<Pedido> pedidos = new ArrayList<>();

    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }
    public void atualizar(Pedido pedidoExistente, Pedido pedidoAtualizado) {
        int index = pedidos.indexOf(pedidoExistente);
        if (index != -1) {
            pedidos.set(index, pedidoAtualizado);
        }
    }

    public void remover(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public void listarTodos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido +"\n");
        }
    }

    public List<Pedido> listarPorID(int pedidoID) {
        return pedidos.stream()
                .filter(pedido -> pedido.getPedidoID() == pedidoID)
                .collect(Collectors.toList());
    }
    

}