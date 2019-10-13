package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.model.Bucket;
import internetshop.model.User;
import internetshop.service.BucketService;
import internetshop.service.UserService;
import internetshop.util.HashUtil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class RegistrationUserController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(RegistrationUserController.class);
    @Inject
    private static UserService userService;
    @Inject
    private static BucketService bucketService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Bucket newBucket = new Bucket();
        newBucket = bucketService.create(newBucket);
        logger.info("Created empty user bucket");

        byte[] salt = HashUtil.getSalt();
        String hashedPassword = HashUtil.hashPassword(req.getParameter("password"), salt);
        User newUser = new User(req.getParameter("login"),
                hashedPassword,
                salt,
                req.getParameter("name"),
                req.getParameter("surname"),
                newBucket);
        userService.create(newUser);
        logger.info("User added: " + newUser);

        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
