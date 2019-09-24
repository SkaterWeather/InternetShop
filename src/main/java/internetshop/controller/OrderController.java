package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.service.OrderService;
import org.apache.log4j.Logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(OrderController.class);
    @Inject
    private static OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession(true).getAttribute("userId");
        orderService.completeOrder(userId);
        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
        logger.info("User[" + userId + "] completed an order");
    }
}
