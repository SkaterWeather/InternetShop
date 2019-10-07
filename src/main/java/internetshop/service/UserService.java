package internetshop.service;

import internetshop.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);

    User get(Long id);

    User update(User user);

    void delete(Long id);

    User getByLogin(String login);

    List<User> getAll();

    Optional<User> getByToken(String token);
}
