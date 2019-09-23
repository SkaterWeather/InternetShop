package internetshop.service;

import internetshop.model.Order;
import internetshop.model.User;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    List<Order> getOrders(Long userId);

    User login(String login, String password) throws AuthenticationException;

    User create(User user);

    User get(Long id);

    Optional<User> getByToken(String token);

    User update(User user);

    void delete(Long id);

    void delete(User user);
}
