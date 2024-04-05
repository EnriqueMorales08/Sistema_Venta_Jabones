/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import bn.dao.Login_Dao;
import bn.dao.Pedido_Dao;
import bn.dao.Producto_Dao;
import bn.model.DetallePedido;
import bn.model.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Carrito_Servlet", urlPatterns = {"/webs/Carrito_Servlet"})
public class Carrito_Servlet extends HttpServlet {

    private Producto_Dao productoDao;
    private Pedido_Dao pedido_Dao;

    @Override
    public void init() {
        productoDao = new Producto_Dao();
        pedido_Dao = new Pedido_Dao();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("idproduct");
        String accion = request.getParameter("accion");
        Integer idProduct = null;
        if (id != null) {
            idProduct = Integer.parseInt(id);
        }

        if (accion != null) {
            String redirect = "carrito.jsp";
            HttpSession sesion = request.getSession();
            List<DetallePedido> list = (List<DetallePedido>) sesion.getAttribute("listCarrito");

            switch (accion.toUpperCase()) {
                case "ELIMINAR":
                    if (list != null) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getIdProd().equals(idProduct)) {
                                list.remove(i);
                            }
                        }
                    }
                    break;
                case "AUMENTAR":
                    if (list != null) {
                        Integer idprod = Integer.parseInt(request.getParameter("idprod1"));
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getIdProd().equals(idprod)) {
                                DetallePedido detalle = list.get(i);
                                list.remove(i);
                                detalle.setCantidad(detalle.getCantidad() + 1);
                                detalle.setSubTotal(detalle.getCantidad() * detalle.getPrecio());
                                list.add(detalle);
                                sesion.setAttribute("listCarrito", list);
                                break;
                            }
                        }
                    }
                    break;
                case "QUITAR":
                    if (list != null) {
                        Integer idprod = Integer.parseInt(request.getParameter("idprod2"));
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getIdProd().equals(idprod)) {
                                DetallePedido detalle = list.get(i);

                                if (detalle.getCantidad() - 1 >= 1) {
                                    list.remove(i);
                                    detalle.setCantidad(detalle.getCantidad() - 1);
                                    detalle.setSubTotal(detalle.getCantidad() * detalle.getPrecio());
                                    list.add(detalle);
                                    sesion.setAttribute("listCarrito", list);
                                }

                                break;
                            }
                        }
                    }
                    break;
                case "COMPRAR":
                    if (list != null) {
                        try{
                            boolean res = pedido_Dao.regitrarPedido(list);
                            if(res){
                                redirect = "compraFinalizada.jsp";
                                sesion.setAttribute("listCarrito", null);
                            }
                        }catch (Exception e){
                            
                        }
                    }
                    break;
            }
            response.sendRedirect(redirect);
        } else {

            if (idProduct != null) {
                HttpSession sesion = request.getSession();
                List<DetallePedido> list = (List<DetallePedido>) sesion.getAttribute("listCarrito");

                boolean encontrado = false;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getIdProd().equals(idProduct)) {
                            DetallePedido detalle = list.get(i);
                            list.remove(i);
                            detalle.setCantidad(detalle.getCantidad() + 1);
                            detalle.setSubTotal(detalle.getPrecio() * detalle.getCantidad());
                            list.add(detalle);
                            encontrado = true;
                            break;
                        }
                    }
                } else {
                    list = new ArrayList<>();
                }

                if (encontrado == false) {
                    try {
                        Producto producto = productoDao.obtenerProducto(idProduct);

                        if (producto.getIdProd() != null) {
                            DetallePedido detalle = new DetallePedido();
                            detalle.setIdProd(producto.getIdProd());
                            detalle.setPrecio(producto.getPrecio());
                            detalle.setTituloProducto(producto.getTitulo());
                            detalle.setCantidad(1);
                            detalle.setSubTotal(detalle.getPrecio() * detalle.getCantidad());

                            list.add(detalle);
                        }

                    } catch (Exception e) {

                    }

                }
                sesion.setAttribute("listCarrito", list);
            }

            response.sendRedirect("tienda.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
