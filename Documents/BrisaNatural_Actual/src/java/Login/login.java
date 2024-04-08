package Login;

import conexion.conexionBD;
import java.sql.*;

public class login extends conexionBD{
    
     public boolean validacion(String user, String password){        
        conexionBD cn = new conexionBD();
        PreparedStatement ps;
        ResultSet rs;        
        try{
            String sql="SELECT * FROM login WHERE Correo=? AND Contraseña=?";
            ps=cn.con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            rs=ps.executeQuery();
            
            if(rs.next()){
                return true;
            }
            
            cn.con.close();
        }catch (SQLException e){
            System.out.println("Ocurrio un error: "+e);            
        }
        
        return false;
    }
    
    public boolean registro(int IdCargo, String nombre, String user, String password){
        conexionBD cn = new conexionBD();
        PreparedStatement ps;
        try{
            String sql="INSERT INTO login VALUES (?, ?, ?, ?)";
            ps=cn.con.prepareStatement(sql);            
            ps.setString(1, user);
            ps.setString(2, password);
            ps.setString(3, nombre);
            ps.setInt(4, IdCargo);
            
            if(ps.executeUpdate()==1){
                return true;
            }
            
            cn.con.close();
        }catch (SQLException e){
            System.out.println("Ocurrio un error: "+e);            
        }
        
        return false;
    }

}
