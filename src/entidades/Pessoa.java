package entidades;

abstract class Pessoa {
	 public String nome;
	 public String endereco;
	 public String documento;
	
	 public Pessoa (String nome, String endereco, String documento) {
	     this.nome = nome;
	     this.endereco = endereco;
	     this.documento = documento;
	 }
	
	 abstract boolean verificarNome();
	 
	 public String getNome(){
	     return nome;
	}
	
	public void setNome(String nome) {
	    this.nome = nome;
	}
	
	 public String getDocumento(){
	     return documento;
	 }
	
	 public void setDocumento(String documento){
	     this.documento=documento;
	 }
	
	 public String getEndereco(){
	     return endereco;
	 }
	
	public void setEndereço(String endereço){
	     this.endereco=endereço;
}

}
