package servicos;


import entidades.Admin;
import repositorios.AdminRepositorio;

public class AdminService {	

    private AdminRepositorio repositorio;   

    public AdminService(AdminRepositorio repositorio) {		
		this.repositorio = repositorio;
	}

	public void criarAdmin(Admin admin) {
		if(validarAdmin(admin)) {			
			repositorio.salvar(admin);
		}else {
			System.out.println("Admin não cadastrado, dados invalido");
		}
    }

    public void atualizarAdmin(Admin adminExistente, Admin adminAtualizado) {
        repositorio.atualizar(adminExistente , adminAtualizado);
    }

    public void removerAdmin(Admin admin) {
        repositorio.remover(admin);
    }

    public void listarTodosAdmins() {
        repositorio.listarTodos();
    }

    public void buscarAdminsPorUsuario(String usuario) {
    	System.out.println(repositorio.listarPorUsuario(usuario));
    }

    
    
    // validação de admins
    
    public boolean validarAdmin(Admin admin) {
    	if(validarUsuario(admin.getUsuario()) && 
    		validarSenha(admin.getSenha()) ){
    		return true;
    	}else {
    		return false;
    	}
    }
    
    private boolean validarUsuario(String email){
    	return email != null;
    }
    private boolean validarSenha(String senha) {
    	return senha != null;
    }
}