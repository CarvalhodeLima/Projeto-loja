package entidades;

public class Admin{
	String usuario;
	String senha;
	
	public Admin(String usuario,String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public String getSenha() {
		return this.senha;
	}
}
