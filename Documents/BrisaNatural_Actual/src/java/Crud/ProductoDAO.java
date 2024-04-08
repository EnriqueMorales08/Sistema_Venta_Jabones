package Crud;

import conexion.conexionBD;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class ProductoDAO implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    Connection cn;
    conexionBD conex = new conexionBD();

    @Override
    public List listar() {

        List<Producto> datos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try {

            cn = conex.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("IdProd"));
                p.setImg(rs.getBinaryStream("Img"));
                p.setTitulo(rs.getString("Titulo"));
                p.setDescripción(rs.getString("Descripcion"));
                p.setGramos(rs.getString("Gramos"));
                p.setPrecio(rs.getString("Precio"));
                p.setTipopiel(rs.getString("TipoPiel"));
                p.setCategoria(rs.getString("Categoria"));
                datos.add(p);
            }
        } catch (Exception e) {
        }

        return datos;

    }

    @Override
    public void listarImg(int id, HttpServletResponse response) {

        String sql = "SELECT * FROM productos WHERE IdProd=" + id;
        InputStream in = null;
        OutputStream out = null;
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        response.setContentType("image/*");
        try {
            out = response.getOutputStream();
            cn = conex.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                in=rs.getBinaryStream("Img");
            }
            bin=new BufferedInputStream(in);
            bout=new BufferedOutputStream(out);
            int i=0;
            while((i=bin.read())!=-1){
                bout.write(i);
            }
            
            in.close();
            out.close();
            bin.close();
            bout.close();
            
        } catch (Exception e) {
        }

    }

    @Override
    public boolean add(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean edit(Producto pro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
