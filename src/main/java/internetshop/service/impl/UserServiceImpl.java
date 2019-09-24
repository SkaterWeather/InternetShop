package internetshop.service.impl;

import internetshop.annotation.Inject;
import internetshop.annotation.Service;
import internetshop.dao.UserDao;
import internetshop.model.Order;
import internetshop.model.User;
import internetshop.service.UserService;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private static UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<Order> getOrders(Long userId) {
        return userDao.get(userId).getPurchaseHistory();
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User login(String login, String password) throws AuthenticationException {
         return userDao.login(login, password);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public Optional<User> getByToken(String token) {
        return userDao.getByToken(token);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
