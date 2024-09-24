package servicos.interfaces;
import entidades.Cliente;
import java.util.List;
public interface IClienteService {

        public void salvar(Cliente cliente);

        public void atualizar(Cliente clienteExistente, Cliente clienteAtualizado);

        public void remover(Cliente cliente) ;

        public List<Cliente> listarTodos() ;

        public List<Cliente> listarPorCliente(Cliente cliente);
}
