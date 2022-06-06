package edu.school21.cinema.servlets;

import edu.school21.cinema.exceptions.ErrorException;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UsersService;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
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
        if (session.getAttribute("user") != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/jsp/signInPage.jsp").forward(req, resp);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");

        if (phoneNumber != null && !phoneNumber.isEmpty() && password != null && !password.isEmpty()) {
            User user = usersService.login(phoneNumber, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
                return;
            }
        }
        doGet(req, resp);
    }
}
