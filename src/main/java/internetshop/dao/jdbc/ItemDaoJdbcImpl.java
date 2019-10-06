package internetshop.dao.jdbc;

import internetshop.annotation.Dao;
import internetshop.dao.ItemDao;
import internetshop.model.Item;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Dao
public class ItemDaoJdbcImpl extends AbstractDao<Item> implements ItemDao {
    private static final Logger logger = Logger.getLogger(ItemDaoJdbcImpl.class);

    public ItemDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Item create(Item item) {
        String query = "INSERT INTO items (name, price) VALUES (?, ?);";

        try (PreparedStatement statement =
                     connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getLong("id"));
            }
        } catch (SQLException e) {
            logger.error("Can't create item " + item);
        }
        return item;
    }

    @Override
    public Item get(Long id) {
        String query = "SELECT * FROM items WHERE id=?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                return new Item(id, name, price);
            }
        } catch (SQLException e) {
            logger.error("Can't get item by ID " + id);
        }
        return null;
    }

    @Override
    public List<Item> getAll() {
        String query = "SELECT * FROM items;";
        List<Item> resultList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

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
        String query = "UPDATE items SET name=?, price=? WHERE id=?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setLong(3, item.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can't update item " + item);
        }
        return item;
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM items WHERE id=?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can't delete item by ID " + id);
        }
    }
}
