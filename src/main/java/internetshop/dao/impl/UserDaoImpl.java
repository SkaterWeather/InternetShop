package internetshop.dao.impl;

import internetshop.annotation.Dao;
import internetshop.dao.ImagineDateBase;
import internetshop.dao.UserDao;
import internetshop.model.User;

import java.util.NoSuchElementException;

@Dao
public class UserDaoImpl implements UserDao {

    @Override
    public User create(User user) {
        ImagineDateBase.usersList.add(user);
        return user;
    }

    @Override
    public User get(Long id) {
        return ImagineDateBase.usersList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
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

    @Override
    public void delete(User user) {
        ImagineDateBase.usersList.removeIf(s -> s.equals(user));
    }
}
