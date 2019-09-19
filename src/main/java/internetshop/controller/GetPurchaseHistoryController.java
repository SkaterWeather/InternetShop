package internetshop.controller;

import internetshop.annotation.Inject;
import internetshop.model.Order;
import internetshop.service.UserService;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetPurchaseHistoryController extends HttpServlet {
    @Inject
    private static UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userId = req.getParameter("user_id");
        List<Order> history = userService.get(Long.valueOf(userId)).getPurchaseHistory();
        req.setAttribute("history", history);
        req.getRequestDispatcher("WEB-INF/view/purchase-history.jsp").forward(req, resp);
    }
}
