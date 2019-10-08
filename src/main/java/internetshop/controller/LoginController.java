package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.model.User;
import internetshop.service.UserService;
import internetshop.util.HashUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

public class LoginController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LoginController.class);
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

        User user = userService.getByLogin(login);
        byte[] salt = user.getSalt();
        if (HashUtil.hashPassword(password, salt).equals(user.getPassword())) {
            Cookie cookie = new Cookie("mate", user.getToken());
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/index");
            logger.info("User authenticated under login: " + login);

            HttpSession session = req.getSession(true);
            session.setAttribute("userId", user.getId());
            logger.info("New session started under userId: " + user.getId());
        } else {
            req.setAttribute("errorMsg", "Incorrect login or password, please try again!");
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }
    }
}

