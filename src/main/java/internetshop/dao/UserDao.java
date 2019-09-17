package internetshop.dao;

import internetshop.model.User;

import java.util.List;

public interface UserDao {
    User create(User user);

    User get(Long id);

    List<User> getAll();

    User update(User user);

    void delete(Long id);

    void delete(User user);
}
