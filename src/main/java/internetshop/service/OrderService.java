package internetshop.service;

import internetshop.model.Order;

public interface OrderService {

    Order completeOrder(Long userId);

    Order create(Order order);

    Order get(Long id);

    Order update(Order order);

    void delete(Long id);

    void delete(Order order);
}
