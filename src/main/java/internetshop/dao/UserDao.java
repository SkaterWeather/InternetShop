package internetshop.dao;

import internetshop.model.User;

import javax.naming.AuthenticationException;
import java.util.List;

public interface UserDao {
    User create(User user);

    User login(String login, String password) throws AuthenticationException;

    User get(Long id);

    List<User> getAll();

    User update(User user);

    void delete(Long id);

    void delete(User user);
}
