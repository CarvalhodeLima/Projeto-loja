package dao;

import DatabaseConnection.DatabaseConnection;
import model.Pedido;

import java.sql.*;

public class PedidoDAO {

    public void criar(Pedido pedido) {
        String sql = "INSERT INTO pedido (cliente_id, total) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pedido.getClienteId());
            stmt.setDouble(2, pedido.getTotal());
            stmt.executeUpdate();

            System.out.println("Pedido inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void listarTodos() {
        String sql = "SELECT * FROM pedido";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Cliente ID: " + rs.getInt("cliente_id") +
                        ", Total: " + rs.getDouble("total"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
