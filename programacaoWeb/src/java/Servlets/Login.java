package Servlets;

import Controllers.LoginController;
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

    private LoginController _controller;
    
    @Override
    public void init() throws ServletException {
        super.init();
        
        _controller = new LoginController();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = new User();
        user.setLogin( request.getParameter("login") );
        user.setPassword( request.getParameter("password") );
        
        user = _controller.isUserValid(user);
        
        if (user == null) {
            response.sendRedirect("index.html");
        } else {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("inicial.jsp");
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
