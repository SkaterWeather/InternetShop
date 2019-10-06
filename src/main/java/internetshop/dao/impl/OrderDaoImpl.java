package internetshop.dao.impl;

import internetshop.annotation.Dao;
import internetshop.dao.ImagineDateBase;
import internetshop.dao.OrderDao;
import internetshop.model.Order;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Dao
public class OrderDaoImpl implements OrderDao {

    @Override
    public Order create(Order order) {
        ImagineDateBase.ordersList.add(order);
        return order;
    }

    @Override
    public Order get(Long id) {
        return ImagineDateBase.ordersList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Order update(Order order) {
        int index = ImagineDateBase.ordersList.indexOf(order);
        ImagineDateBase.ordersList.set(index, order);
        return order;
    }

    @Override
    public void delete(Long id) {
        ImagineDateBase.ordersList.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public List<Order> getAllOrdersByUserId(Long userId) {
        return ImagineDateBase.ordersList.stream()
                .filter(s -> s.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
