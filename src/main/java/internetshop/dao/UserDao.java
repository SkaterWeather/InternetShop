package internetshop.dao;

import internetshop.model.User;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    User create(User user);

    User get(Long id);

    User update(User user);

    void delete(Long id);

    User login(String login, String password) throws AuthenticationException;

    List<User> getAll();

    Optional<User> getByToken(String token);
}
