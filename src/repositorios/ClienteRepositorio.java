package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import entidades.Cliente;

public class ClienteRepositorio {

    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }
  
    public void atualizar(Cliente clienteExistente, Cliente clienteAtualizado) {
		int index = clientes.indexOf(clienteExistente);
        if (index != -1) {
            clientes.set(index, clienteAtualizado);
        }
    }

    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void listarTodos() {
        for (Cliente cliente : clientes) {
             System.out.println(cliente +"\n");
        }
    }

    public List<Cliente> listarPorNome(String nome) {
        return clientes.stream()
            .filter(cliente -> cliente.getNome().equalsIgnoreCase(nome))
            .collect(Collectors.toList());
    }

    public Cliente buscarPorCPF(String cpf) {
        return clientes.stream()
                .filter(cliente -> cpf.equals(cliente.getDocumento()))
                .findFirst()
                .orElse(null);
    }
    
    public Cliente buscarClientePorEmailESenha(String email, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        return null; // Retorna null se não encontrar nenhum cliente com as credenciais fornecidas
    }
}

