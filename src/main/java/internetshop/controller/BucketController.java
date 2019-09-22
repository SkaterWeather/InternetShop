package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.controller.inits.DataInitializer;
import internetshop.model.Item;
import internetshop.service.BucketService;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BucketController extends HttpServlet {
    @Inject
    private static BucketService bucketService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession(true).getAttribute("userId");
        List items = bucketService.getAllItems(userId);
        req.setAttribute("items", items);
        req.getRequestDispatcher("/WEB-INF/view/bucket.jsp").forward(req, resp);
    }
}
