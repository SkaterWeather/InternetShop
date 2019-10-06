package internetshop.dao.impl;

import internetshop.annotation.Dao;
import internetshop.dao.ImagineDateBase;
import internetshop.dao.UserDao;
import internetshop.model.User;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Dao
public class UserDaoImpl implements UserDao {

    @Override
    public User create(User user) {
        ImagineDateBase.usersList.add(user);
        return user;
    }

    @Override
    public User getByLogin(String login){
        Optional<User> user = ImagineDateBase.usersList.stream()
                .filter(s -> s.getLogin().equals(login))
                .findFirst();
        return user.get();
    }

    @Override
    public User get(Long id) {
        return ImagineDateBase.usersList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User getByToken(String token) {
        return ImagineDateBase.usersList.stream()
                .filter(s -> s.getToken().equals(token))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> getAll() {
        return ImagineDateBase.usersList;
    }

    @Override
    public User update(User user) {
        int index = ImagineDateBase.usersList.indexOf(user);
        ImagineDateBase.usersList.set(index, user);
        return user;
    }

    @Override
    public void delete(Long id) {
        ImagineDateBase.usersList.removeIf(s -> s.getId().equals(id));
    }
}
