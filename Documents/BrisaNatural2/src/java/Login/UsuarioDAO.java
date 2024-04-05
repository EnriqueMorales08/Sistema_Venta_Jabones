package Login;

import BD.ConexionBD;
import java.sql.*;


public class UsuarioDAO implements Validacion{
    
    ConexionBD cn = new ConexionBD();
    PreparedStatement ps;
    ResultSet rs;
      

    @Override
    public int Validacion(Usuario user) {
        int r=0; 
        try{
            ps=cn.con.prepareStatement("SELECT * FROM login WHERE Correo=? "
                    + "AND Contraseña=?");            
            ps.setString(1,user.getCorreo());
            ps.setString(3,user.getContraseña());
            rs=ps.executeQuery();
            while (rs.next()){
                r=r+1;
                user.setCorreo(rs.getString("Correo"));
                user.setContraseña(rs.getString("Contraseña"));
            } 
            if(r==1){
                return 1;
            }else{
                return 0;
            }
            
        } catch (SQLException e){
            return 0;          
        }
        
        
    }

}
