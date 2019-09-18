package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.model.User;
import internetshop.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationUserController extends HttpServlet {
    @Inject
    private static UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User newUser = new User(req.getParameter("login"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("surname"));
        userService.create(newUser);
        System.out.println("User added: " + newUser);
        resp.sendRedirect(req.getContextPath() + "/users");
    }
}
