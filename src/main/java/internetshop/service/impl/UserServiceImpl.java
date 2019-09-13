package internetshop.service.impl;

import internetshop.annotation.Inject;
import internetshop.annotation.Service;
import internetshop.dao.UserDao;
import internetshop.model.User;
import internetshop.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private static UserDao userDao;

    @Override
    public List getOrders(Long userId) {
        return userDao.get(userId).getPurchaseHistory();
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
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
