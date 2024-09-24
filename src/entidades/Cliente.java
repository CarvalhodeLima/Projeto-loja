package entidades;

public class Cliente extends Pessoa {
    private int clienteID;
    private String email;
    private String senha;

    public Cliente(int clienteID, String nome, String documento, String email, String endereco, String senha) {
        super(nome, endereco, documento);
        this.clienteID = clienteID;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public boolean verificarNome() {
        return getNome() != null && !getNome().isEmpty();
    }

    // Métodos Get

    public int getClienteID() {
        return this.clienteID;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    public String getEmail() {
        return this.email;
    }

    public String getEndereco() {
        return super.getEndereco();
    }

    public String getSenha() {
        return this.senha;
    }

    @Override
    public String getDocumento() {
        return super.getDocumento();
    }

    @Override
    public String toString() {
        return "Cliente " + clienteID + ": " +
                "\nNome do cliente: " + getNome() +
                "\nCPF: " + getDocumento() +
                "\nE-mail: " + getEmail() +
                "\nEndereço: " + getEndereco();

    }
}
