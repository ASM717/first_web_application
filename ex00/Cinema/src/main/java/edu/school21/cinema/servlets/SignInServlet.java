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

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    public SignInServlet() {
        super();
    }

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
    }

    public void destroy() {
        super.destroy();
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNumber = req.getParameter("phone_number");
        String password = req.getParameter("password");

        if (phoneNumber != null && !phoneNumber.isEmpty() && password != null && !password.isEmpty()) {
            User user = userService.authorize(phoneNumber, password);
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
