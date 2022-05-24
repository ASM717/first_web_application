package edu.school21.cinema.servlets;

import edu.school21.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


public class FirstServlets extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1> Hello world! </h1>");
        printWriter.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
