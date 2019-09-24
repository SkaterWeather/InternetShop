package internetshop.service.impl;

import internetshop.annotation.Inject;
import internetshop.annotation.Service;
import internetshop.dao.BucketDao;
import internetshop.dao.OrderDao;
import internetshop.dao.UserDao;
import internetshop.model.Bucket;
import internetshop.model.Order;
import internetshop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private static OrderDao orderDao;
    @Inject
    private static UserDao userdao;
    @Inject
    private static BucketDao bucketDao;

    @Override
    public Order completeOrder(Long userId) {
        Bucket bucket = bucketDao.get(userdao.get(userId).getBucketId());
        Order order = new Order(userId, bucket.getItems());
        userdao.get(userId).addToPurchaseHistory(order);
        orderDao.create(order);
        bucket.clearItems();
        return order;
    }

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
        orderDao.delete(id);
    }

    @Override
    public void delete(Order order) {
        orderDao.delete(order);
    }
}
