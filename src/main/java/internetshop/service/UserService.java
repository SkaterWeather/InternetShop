package internetshop.service;

import internetshop.model.Order;
import internetshop.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    List<Order> getOrders(Long userId);

    User create(User user);

    User get(Long id);

    User update(User user);

    void delete(Long id);

    void delete(User user);
}
