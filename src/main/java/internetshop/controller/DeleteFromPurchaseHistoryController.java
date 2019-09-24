package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.service.UserService;
import org.apache.log4j.Logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFromPurchaseHistoryController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(DeleteFromPurchaseHistoryController.class);
    @Inject
    private static UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession(true).getAttribute("userId");
        String orderId = req.getParameter("order_id");
        userService.get(userId).deleteFromPurchaseHistory(Long.valueOf(orderId));
        logger.info("Order[" + orderId + "] deleted, userId = " + userId);
        //TODO: trying to redirect on index page '/purchase-history'
        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
