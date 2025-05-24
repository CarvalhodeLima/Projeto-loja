package model;


public class Pedido {
    private int id;
    private int clienteId;
    private double total;

    public Pedido() {}

    public Pedido(int id, int clienteId, double total) {
        this.id = id;
        this.clienteId = clienteId;
        this.total = total;


    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
