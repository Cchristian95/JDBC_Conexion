package JDBC;

import java.sql.*;

public class Insertar {

    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/productos";

    public void conex() {
        //Variables de conexion
        Connection conn;

        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Conexion Exitosa");
            }
            String query = "INSERT INTO  producto(nombre, codigo, precio) VALUES (? ? ?)";
            PreparedStatement tx = conn.prepareStatement(query);
            tx.setString(1, "Gorra");
            tx.setInt(2, 10);
            tx.setDouble(3, 15);

            int row = tx.executeUpdate();

            if (row > 0) {
                System.out.println("Se agrego correctamente la informacion");

            }

        } catch (Exception e) {
            System.out.println("Error de Conexion" + e.getMessage());
        }
    }
}
