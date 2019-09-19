package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.controller.inits.DataInitializer;
import internetshop.model.User;
import internetshop.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFromPurchaseHistoryController extends HttpServlet {
    @Inject
    private static UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //TODO: get user_id from current user in session;
        String orderId = req.getParameter("order_id");
        User currentUser = userService.get(DataInitializer.DEFAULT_USER_ID);
        currentUser.deleteFromPurchaseHistory(Long.valueOf(orderId));
        resp.sendRedirect(req.getContextPath() + "/purchase-history");
    }
}
