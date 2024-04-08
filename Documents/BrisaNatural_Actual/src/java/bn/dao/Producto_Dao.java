package bn.dao;

import bn.model.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Producto_Dao {

    public Producto obtenerProducto(Integer idProduct) throws ClassNotFoundException {
        Producto producto = new Producto();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webintegpf?user=root&password=");
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("select * from productos where IdProd = " + idProduct);

            while (rs.next()) {
                producto.setIdProd(rs.getInt("IdProd"));
                producto.setTitulo(rs.getString("Titulo"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setGramos(rs.getString("Gramos"));
                producto.setPrecio(rs.getDouble("Precio"));
                break;
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return producto;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
