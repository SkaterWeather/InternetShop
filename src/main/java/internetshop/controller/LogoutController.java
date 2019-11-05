package internetshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

public class LogoutController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LogoutController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.invalidate();
        Cookie cookie = new Cookie("mate", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
