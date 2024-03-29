package internetshop.service.impl;

import internetshop.annotation.Inject;
import internetshop.annotation.Service;
import internetshop.dao.BucketDao;
import internetshop.dao.UserDao;
import internetshop.model.Bucket;
import internetshop.model.User;
import internetshop.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private static UserDao userDao;

    @Inject
    private static BucketDao bucketDao;

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public Optional<User> getByToken(String token) {
        return Optional.of(userDao.getByToken(token));
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        Bucket bucket = userDao.get(id).getBucket();
        bucket.clearItems();
        bucketDao.update(bucket);
        userDao.delete(id);
    }
    
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }
}
