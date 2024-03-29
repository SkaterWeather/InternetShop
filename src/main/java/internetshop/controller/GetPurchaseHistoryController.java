package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.model.Order;
import internetshop.service.OrderService;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetPurchaseHistoryController extends HttpServlet {
    @Inject
    private static OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = (Long) req.getSession(true).getAttribute("userId");
        List<Order> history = orderService.getAllOrdersByUserId(userId);
        req.setAttribute("history", history);
        req.getRequestDispatcher("WEB-INF/view/purchase-history.jsp").forward(req, resp);
    }
}
