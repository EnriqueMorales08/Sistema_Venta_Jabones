package Login;

import java.io.*;
import javax.servlet.RequestDispatcher;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Control", urlPatterns=("/Control"))
public class Control extends HttpServlet {

    UsuarioDAO dao=new UsuarioDAO();
    Usuario u=new Usuario();
    int r;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String accion=request.getParameter("accion");
        if(accion.equals("Ingresar")){
            String correo = request.getParameter("correo");
            String contraseña = request.getParameter("contraseña");
            u.setCorreo(correo);
            u.setContraseña(contraseña);
            r=dao.Validacion(u);
            if(r==1){
                request.getSession().setAttribute("correo", correo);
                request.getSession().setAttribute("contraseña", contraseña);
                request.getRequestDispatcher("/BrisaNaturalNB/principal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/BrisaNaturalNB/index.jsp").forward(request, response);
            }
        }else{
               request.getRequestDispatcher("/BrisaNaturalNB/index.jsp").forward(request, response);

        }
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
