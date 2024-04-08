package Crud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface CRUD {

    public List listar();
    public void listarImg(int id,HttpServletResponse response);
    public boolean add(Producto pro);
    public boolean edit(Producto pro);
    public boolean delete(int id);
    
}
