package BD;

import java.sql.*;

public class ConexionBD {
    
    public Connection con;    
    public ConexionBD(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webintegpf","root","");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Ocurrio un error inesperado: "+e);
        }
    }

    public Connection getConnection(){
        return con;
    }
}
