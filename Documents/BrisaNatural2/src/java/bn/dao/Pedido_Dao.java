package bn.dao;

import bn.model.DetallePedido;
import bn.model.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

public class Pedido_Dao {

    public boolean regitrarPedido(List<DetallePedido> listDetalle) throws ClassNotFoundException {
        boolean end = false;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webintegpf?user=root&password=");
            PreparedStatement statement = con.prepareStatement("INSERT INTO pedido (fecha) values (now())");
            int n = statement.executeUpdate();

            if (n != 0) {
                Statement sta = con.createStatement();
                ResultSet rs = sta.executeQuery("select * from pedido order by idpedido desc");

                Integer idPedido = 0;
                while (rs.next()) {
                    idPedido = rs.getInt("idpedido");
                    break;
                }

                if (idPedido != 0) {
                    for (int i = 0; i < listDetalle.size(); i++) {
                        DetallePedido detalle = listDetalle.get(i);
                        PreparedStatement statement2 = 
                                con.prepareStatement("INSERT INTO detallepedido (idproducto,precio,cantidad,"
                                        + "subtotal,idpedido) values (?,?,?,?,?)");
                        statement2.setInt(1, detalle.getIdProd());
                        statement2.setDouble(2, detalle.getPrecio());
                        statement2.setInt(3, detalle.getCantidad());
                        statement2.setDouble(4, detalle.getSubTotal());
                        statement2.setInt(5,idPedido);
                        statement2.execute();
                    }
                    end = true;
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return end;
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
