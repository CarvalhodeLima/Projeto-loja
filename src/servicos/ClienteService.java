package servicos;


import entidades.Cliente;
import repositorios.ClienteRepositorio;

public class ClienteService {	

    private ClienteRepositorio repositorio;   

    public ClienteService(ClienteRepositorio repositorio) {		
		this.repositorio = repositorio;
	}

	public void criarClientes(Cliente cliente) {
		if(validarCliente(cliente)) {			
			repositorio.salvar(cliente);
		}else {
			System.out.println("Cliente não cadastrado, dados invalido");
		}
    }

    public void atualizarCliente(Cliente clienteExistente, Cliente clienteAtualizado) {
        repositorio.atualizar(clienteExistente , clienteAtualizado);
    }

    public void ExcluirCliente(Cliente cliente) {
        repositorio.remover(cliente);
    }

    public void listarTodosClientes() {
        repositorio.listarTodos();
    }

    public void buscarClientesPorNome(String nome) {
    	System.out.println(repositorio.listarPorNome(nome));
    }

    public void buscarClientePorCPF(String cpf) {
        System.out.println(repositorio.buscarPorCPF(cpf));
    }
    
    
    // validação de clientes
    
    public boolean validarCliente(Cliente cliente) {
    	if(validarNome(cliente.getNome()) && 
    			validarCPF(cliente.getDocumento()) && 
    			validarEmail(cliente.getEmail()) && 
    			validarEndereco(cliente.getEndereco()) && 
    			validarSenha(cliente.getSenha())
    			) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    private boolean validarNome(String nome) {
    	return nome != null;
    }
    private boolean validarCPF(String cpf) {
    	return cpf.length() >= 11 && cpf.length() <= 14;
    }
    private boolean validarEmail(String email){
    	return email != null && email.contains("@");
    }
    private boolean validarEndereco(String endereco) {
    	return endereco != null;
    }
    private boolean validarSenha(String senha) {
    	return senha != null;
    }
}