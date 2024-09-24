package repositorios.interfaces;
import entidades.Produto;
import java.util.List;
public interface IProdutoRepositorio {

        public void salvar(Produto produto);

        public void atualizar(Produto produtoExistente, Produto produtoAtualizado);

        public void remover(Produto produto) ;

        public List<Produto> listarTodos() ;

        public List<Produto> listarPorProduto(Produto produto);
    }
