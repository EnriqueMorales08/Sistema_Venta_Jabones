package Servlets;

import bn.beans.Login_Bean;
import bn.dao.Login_Dao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginservlet")
public class Login_Servlet extends HttpServlet {
    private Login_Dao loginDao;

    @Override
    public void init() {
        loginDao = new Login_Dao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/");
        rd.forward(request, response);
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Login_Bean loginBean = new Login_Bean();
            loginBean.setUsername(username);
            loginBean.setPassword(password);
            
            
            if (loginDao.validate(loginBean)) {
                response.sendRedirect("./webs/userpage.jsp");
            } else {
                HttpSession session;
                session = request.getSession();
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}