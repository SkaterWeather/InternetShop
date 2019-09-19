package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.controller.inits.DataInitializer;
import internetshop.service.BucketService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddToBucketController extends HttpServlet {
    @Inject
    private static BucketService bucketService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //TODO: get bucket id from current user; from page items.jsp
        String itemId = req.getParameter("item_id");
        bucketService.addItem(DataInitializer.DEFAULT_BUCKET_ID, Long.valueOf(itemId));
        resp.sendRedirect(req.getContextPath() + "/items");
    }
}
