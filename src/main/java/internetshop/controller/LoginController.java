package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.model.User;
import internetshop.service.UserService;
import org.apache.log4j.Logger;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(RegistrationUserController.class);
    @Inject
    private static UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            User user = userService.login(login, password);
            Cookie cookie = new Cookie("mate", user.getToken());
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/index");
            logger.info("User authenticated under login: " + login);

            HttpSession session = req.getSession(true);
            session.setAttribute("userId", user.getId());
            logger.info("New session started under userId: " + user.getId());
        } catch (AuthenticationException e) {
            req.setAttribute("errorMsg", "Incorrect login or password, please try again!");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }
    }
}

