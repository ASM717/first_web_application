package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;
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
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            req.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/jsp/signUpPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/jsp");
        String firstname = req.getParameter("first_name");
        String lastname = req.getParameter("last_name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone_number");
        String password = req.getParameter("password");
        User user = new User(firstname, lastname, email, phone, password);
        if (userService.saveUser(firstname, lastname, email, phone, password)) {
            req.getRequestDispatcher("WEB-INF/jsp/signInPage.jsp").forward(req, resp);
//            req.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(req, resp);
        } else {
            doGet(req, resp);
        }
    }
}