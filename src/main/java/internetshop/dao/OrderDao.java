package internetshop.dao;

import internetshop.model.Order;

import java.util.List;

public interface OrderDao {
    Order create(Order order);

    Order get(Long id);

    Order update(Order order);

    void delete(Long id);

    List<Order> getAllOrdersByUserId(Long userId);
}
