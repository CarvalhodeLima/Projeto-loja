package servicos.interfaces;
import entidades.Pedido;
import java.util.List;
public interface IPedidoService {

        public void salvar(Pedido pedido);

        public void atualizar(Pedido pedidoExistente, Pedido pedidoAtualizada);

        public void remover(Pedido pedido) ;

        public List<Pedido> listarTodos() ;

        public List<Pedido> listarPorPedido(Pedido pedido);
}
