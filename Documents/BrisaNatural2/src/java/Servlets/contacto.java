package Servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yeico
 */
public class contacto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet contacto</title>");
            out.println("</head>");
            out.println("<body>");
            response.sendRedirect("index.jsp");
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
        sendMail(request, response);
        processRequest(request, response);
    }

    public void sendMail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, res);
        String nombres = req.getParameter("fname");
        String apellidos = req.getParameter("pname");
        String dni = req.getParameter("dni");
        String tel = req.getParameter("telefono");
        String correo = "yeicotsarmientopolo2@gmail.com";
        String correo01 = req.getParameter("correo");
        String msj = req.getParameter("mensaje");
        //rnjejagdxjfczzys
        String pass = "rnjejagdxjfczzys";
        String dest = "yeicotsarmientopolo2@gmail.com";
        String content = "Nombres: " + nombres + "\nApellidos: " + apellidos + "\nDni: " + dni + "\nTeléfono: " + tel + "\nCorreo: " + correo01 + "\n\n Mensaje: \n" + msj;
        Session sess;
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.port", "587");
        prop.put("mail.smtp.user", correo);
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.setProperty("mail.smtp.auth", "true");


        sess = Session.getDefaultInstance(prop);
        try {
            MimeMessage mime;
            mime = new MimeMessage(sess);
            mime.setFrom(new InternetAddress(correo));
            mime.setRecipient(Message.RecipientType.TO, new InternetAddress(dest));
            mime.setSubject("MENSAJE DE BRISA NATURAL");
            mime.setText(content);

            Transport trans = sess.getTransport("smtp");
            trans.connect(correo, pass);
            trans.sendMessage(mime, mime.getRecipients(Message.RecipientType.TO));
            trans.close();
        } catch (AddressException e) {
            System.out.println(e);
        } catch (MessagingException e) {
            System.out.println(e);
        }

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
