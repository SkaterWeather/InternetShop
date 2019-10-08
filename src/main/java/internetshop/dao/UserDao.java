package internetshop.dao;

import internetshop.model.User;

import java.util.List;

public interface UserDao {
    User create(User user);

    User get(Long id);

    User update(User user);

    void delete(Long id);

    User getByLogin(String login);

    List<User> getAll();

    User getByToken(String token);
}
