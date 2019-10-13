package internetshop.dao.jdbc;

import internetshop.annotation.Dao;
import internetshop.dao.OrderDao;
import internetshop.model.Item;
import internetshop.model.Order;
import internetshop.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

@Dao
public class OrderDaoJdbcImpl extends AbstractDao<Order> implements OrderDao {
    private static final Logger logger = Logger.getLogger(OrderDaoJdbcImpl.class);

    public OrderDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Order create(Order order) {
        String query = "INSERT INTO orders (user_id, total_price) VALUES (?, ?);";
        String secondQuery = "INSERT INTO orders_items (order_id, item_id) VALUES (?, ?);";

        try (PreparedStatement statement =
                     connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, order.getUserId());
            statement.setDouble(2, order.getTotalPrice());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getLong("id"));
                PreparedStatement secondStatement = connection.prepareStatement(secondQuery);
                for (Item item : order.getItemsList()) {
                    secondStatement.setLong(1, order.getId());
                    secondStatement.setLong(2, item.getId());
                    secondStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            logger.error("Can't create order " + order);
        }
        return order;
    }

    @Override
    public Order get(Long id) {
        String query = "SELECT orders.user_id, items.id, items.name, items.price "
                + "FROM orders "
                + "INNER JOIN orders_items "
                + "ON orders.id = orders_items.order_id "
                + "INNER JOIN items "
                + "ON items.id = orders_items.item_id "
                + "WHERE orders.id = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Item> items = new ArrayList<>();
            long userId = 0L;

            while (resultSet.next()) {
                userId = resultSet.getLong("user_id");
                items.add(new Item(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")));
            }
            return new Order(id, userId, items);
        } catch (SQLException e) {
            logger.error("Can't get order by ID=" + id);
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        String query = "UPDATE orders SET user_id=?, total_price=? WHERE id=?;"
                + "DELETE FROM orders_items WHERE order_id=?;";
        String secondQuery = "INSERT INTO orders_items (order_id, item_id) VALUES (?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(query);
                PreparedStatement secondStatement = connection.prepareStatement(secondQuery)) {
            statement.setLong(1, order.getUserId());
            statement.setDouble(2, order.getTotalPrice());
            statement.setLong(3, order.getId());
            statement.setLong(4, order.getId());
            statement.executeUpdate();

            for (Item item : order.getItemsList()) {
                secondStatement.setLong(1, order.getId());
                secondStatement.setLong(2, item.getId());
                secondStatement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error("Can't update order " + order);
        }
        return order;
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM orders_items WHERE order_id=?;"
                + "DELETE FROM orders WHERE id=?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can't delete order by ID=" + id);
        }
    }

    @Override
    public List<Order> getAllOrdersByUserId(Long userId) {
        String query = "SELECT * FROM orders WHERE user_id=?;";
        List<Order> resultOrders = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                List<Item> items = getItemsByOrderId(id);
                resultOrders.add(new Order(id, userId, items));
            }
        } catch (SQLException e) {
            logger.error("Can't get all orders for userId=" + userId);
        }
        return resultOrders;
    }

    private List<Item> getItemsByOrderId(Long orderId) {
        String query = "SELECT * FROM items "
                + "INNER JOIN orders_items "
                + "ON orders_items.item_id = items.id "
                + "WHERE order_id=?;";
        List<Item> resultItems = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                resultItems.add(new Item(id, name, price));
            }
        } catch (SQLException e) {
            logger.error("Can't get all items from order by id=" + orderId);
        }
        return resultItems;
    }
}
