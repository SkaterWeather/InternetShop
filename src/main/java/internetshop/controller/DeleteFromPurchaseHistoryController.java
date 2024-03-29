package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.service.OrderService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class DeleteFromPurchaseHistoryController extends HttpServlet {
    private static final Logger logger
            = Logger.getLogger(DeleteFromPurchaseHistoryController.class);
    @Inject
    private static OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession(true).getAttribute("userId");
        String orderId = req.getParameter("order_id");
        orderService.delete(Long.valueOf(orderId));
        logger.info("Order[" + orderId + "] deleted, userId = " + userId);
        resp.sendRedirect(req.getContextPath() + "/purchase-history");
    }
}
