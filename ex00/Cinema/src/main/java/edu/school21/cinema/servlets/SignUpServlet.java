package edu.school21.cinema.servlets;

import edu.school21.cinema.exceptions.ErrorException;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("springContext");
        this.usersService = context.getBean(UsersService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        request.getRequestDispatcher("/WEB-INF/jsp/signUpPage.jsp").forward(request, response);
        if (session.getAttribute("user") != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/jsp/signUpPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Map<String, String[]> params = request.getParameterMap();
//        usersService.createUser(params.get("firstName")[0],
//                                params.get("lastName")[0],
//                                params.get("phoneNumber")[0],
//                                params.get("password")[0]);
//        response.sendRedirect(request.getContextPath() + "/signIn");

//        String firstname = req.getParameter("first");
//        String lastname = req.getParameter("last");
//        String email = req.getParameter("email");
//        String phone = req.getParameter("phone");
//        String password = req.getParameter("password");
//        User user = new User(firstname, lastname, phone, password);
//        if (usersService.createUser(firstname, lastname, phone, password)) {
//            // successfull
//        } else {
//            doGet(req, resp);
//        }

    }
}