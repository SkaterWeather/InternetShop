package internetshop.service.impl;

import internetshop.annotation.Inject;
import internetshop.annotation.Service;
import internetshop.dao.RoleDao;
import internetshop.dao.UserDao;
import internetshop.model.User;
import internetshop.service.UserService;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private static UserDao userDao;
    @Inject
    private static RoleDao roleDao;

    @Override
    public List<User> getAll() {
        List<User> users = userDao.getAll();
        for (User user : users) {
            user.setRoles(roleDao.getRolesByUserId(user.getId()));
        }
        return users;
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User getByLogin(String login) {
        User user = userDao.getByLogin(login);
        user.setRoles(roleDao.getRolesByUserId(user.getId()));
        return user;
    }

    @Override
    public User get(Long id) {
        User user = userDao.get(id);
        user.setRoles(roleDao.getRolesByUserId(id));
        return user;
    }

    @Override
    public Optional<User> getByToken(String token) {
        User user = userDao.getByToken(token);
        user.setRoles(roleDao.getRolesByUserId(user.getId()));
        return Optional.of(user);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
