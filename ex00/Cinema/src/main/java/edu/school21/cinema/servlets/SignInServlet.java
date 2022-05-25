package edu.school21.cinema.servlets;

import edu.school21.cinema.exceptions.ErrorException;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UsersService;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();

        User user = null;
        try {
            user = usersService.login(params.get("phoneNumber")[0], params.get("password")[0]);
        } catch (ErrorException e) {
            e.printStackTrace();
        }
//        if (user == null) {
//            Map<String, String> errors = new HashMap<>();
//            errors.put("commonError", "Phone number or password incorrect");
//            Map<String, String> fields = new HashMap<>();
//            fields.put("phoneNumber", params.get("phoneNumber")[0]);

//            request.setAttribute("errors", errors);
//            request.setAttribute("fields", fields);
//            request.getRequestDispatcher("/signInForm").forward(request, response);
//        } else {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);
//            response.sendRedirect(request.getContextPath() + "/allright");
//        }
    }
}
