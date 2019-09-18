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
        //TODO: get bucket id from current user;
        List<Item> items = bucketService.getAllItems(DataInitializer.DEFAULT_BUCKET_ID);
        req.setAttribute("items", items);
        req.getRequestDispatcher("/WEB-INF/view/bucket.jsp").forward(req, resp);
    }
}
