package internetshop.dao.jdbc;

import internetshop.annotation.Dao;
import internetshop.dao.ItemDao;
import internetshop.model.Item;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Dao
public class ItemDaoJdbcImpl extends AbstractDao<Item> implements ItemDao {
    private static final Logger logger = Logger.getLogger(ItemDaoJdbcImpl.class);
    private static final String ITEMS_TABLE = "items";

    public ItemDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Item create(Item item) {
        String query = String.format("INSERT INTO %s (id, name, price) VALUES (%d, '%s', %f);",
                ITEMS_TABLE, item.getId(), item.getName(), item.getPrice());

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("Can't create item " + item);
        }
        return item;
    }

    @Override
    public Item get(Long id) {
        String query = String.format("SELECT * FROM %s WHERE id=%d;",
                ITEMS_TABLE, id);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Long item_id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                return new Item(item_id, name, price);
            }
        } catch (SQLException e) {
            logger.error("Can't get item by ID " + id);
        }
        return null;
    }

    @Override
    public List<Item> getAll() {
        String query = String.format("SELECT * FROM %s;", ITEMS_TABLE);
        List<Item> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Long item_id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                resultList.add(new Item(item_id, name, price));
            }
        } catch (SQLException e) {
            logger.error("Can't get all elements from table 'items'");
        }
        return resultList;
    }

    @Override
    public Item update(Item item) {
        String query = String.format("UPDATE %s SET name='%s', price=%f WHERE id=%d;",
                ITEMS_TABLE, item.getName(), item.getPrice(), item.getId());

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("Can't update item " + item);
        }
        return item;
    }

    @Override
    public void delete(Long id) {
        String query = String.format("DELETE FROM %s WHERE id=%d;",
                ITEMS_TABLE, id);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("Can't delete item by ID " + id);
        }
    }
}
