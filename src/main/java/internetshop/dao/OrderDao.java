package internetshop.dao;

import internetshop.model.Order;

public interface OrderDao {
    Order create(Order order);

    Order get(Long id);

    Order update(Order order);

    void delete(Long id);

    void delete(Order order);
}
