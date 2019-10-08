package internetshop.service;

import internetshop.model.Order;

import java.util.List;

public interface OrderService {
    Order create(Order order);

    Order get(Long id);

    Order update(Order order);

    void delete(Long id);

    Order completeOrder(Long userId);

    List<Order> getAllOrdersByUserId(Long userId);
}
