package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.service.BucketService;
import internetshop.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddToBucketController extends HttpServlet {
    @Inject
    private static BucketService bucketService;
    @Inject
    private static UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession(true).getAttribute("userId");
        Long itemId = Long.valueOf(req.getParameter("item_id"));
        Long bucketId = userService.get(userId).getBucket().getId();
        bucketService.addItem(bucketId, itemId);
        resp.sendRedirect(req.getContextPath() + "/items");
    }
}
