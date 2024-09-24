package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entidades.Admin;

public class AdminRepositorio {

    private List<Admin> admins = new ArrayList<>();

    public void salvar(Admin admin) {
        admins.add(admin);
    }
  
    public void atualizar(Admin adminExistente, Admin adminAtualizado) {
		int index = admins.indexOf(adminExistente);
        if (index != -1) {
            admins.set(index, adminAtualizado);
        }
    }

    public void remover(Admin admin) {
        admins.remove(admin);
    }

    public void listarTodos() {
        for (Admin admin : admins) {
             System.out.println(admin +"\n");
        }
    }

    public List<Admin> listarPorUsuario(String usuario) {
        return admins.stream()
            .filter(admin -> admin.getUsuario().equalsIgnoreCase(usuario))
            .collect(Collectors.toList());
    }
    
    public Admin buscarAdminPorUsuarioESenha(String usuario, String senha) {
        for (Admin admin : admins) {
            if (admin.getUsuario().equals(usuario) && admin.getSenha().equals(senha)) {
                return admin;
            }
        }
        return null;
    }

    
}

