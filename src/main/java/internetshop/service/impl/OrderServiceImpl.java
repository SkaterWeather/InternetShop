package internetshop.service.impl;

import internetshop.annotation.Inject;
import internetshop.annotation.Service;
import internetshop.dao.BucketDao;
import internetshop.dao.OrderDao;
import internetshop.dao.UserDao;
import internetshop.model.Bucket;
import internetshop.model.Order;
import internetshop.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Inject
    private static OrderDao orderDao;

    @Inject
    private static UserDao userDao;

    @Inject
    private static BucketDao bucketDao;

    @Override
    public Order create(Order order) {
        return orderDao.create(order);
    }

    @Override
    public Order get(Long id) {
        return orderDao.get(id);
    }

    @Override
    public Order update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public void delete(Long id) {
        Order order = orderDao.get(id);
        order.clearItems();
        orderDao.update(order);
        orderDao.delete(id);
    }

    @Override
    public Order completeOrder(Long userId) {
        Bucket bucket = userDao.get(userId).getBucket();
        Order order = new Order(userDao.get(userId), bucket.getItems());
        orderDao.create(order);
        bucket.clearItems();
        bucketDao.update(bucket);
        return order;
    }

    @Override
    public List<Order> getAllOrdersByUserId(Long userId) {
        return orderDao.getAllOrdersByUserId(userId);
    }
}
