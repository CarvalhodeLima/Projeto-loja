package repositorios.interfaces;
import entidades.Pedido;
import java.util.List;
public interface IPedidoRepositorio {

    public void salvar(Pedido pedido);

    public void atualizar(Pedido pedidoExistente, Pedido pedidoAtualizado);

    public void remover(Pedido pedido) ;

    public List<Pedido> listarTodos() ;

    public List<Pedido> listarPorPedido(Pedido pedido);
}
