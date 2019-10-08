package internetshop.dao.jdbc;

import internetshop.annotation.Dao;
import internetshop.dao.BucketDao;
import internetshop.model.Bucket;
import internetshop.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

@Dao
public class BucketDaoJdbcImpl extends AbstractDao<Bucket> implements BucketDao {
    private static final Logger logger = Logger.getLogger(BucketDaoJdbcImpl.class);

    public BucketDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Bucket create(Bucket bucket) {
        String query = "INSERT INTO buckets (property) VALUES (?);";

        try (PreparedStatement statement =
                     connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, bucket.getProperty());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                bucket.setId(generatedKeys.getLong("id"));
            }
        } catch (SQLException e) {
            logger.error("Can't create bucket " + bucket);
        }
        return bucket;
    }

    @Override
    public Bucket get(Long id) {
        String query = "SELECT buckets.property, items.id, items.name, items.price "
                + "FROM buckets "
                + "INNER JOIN buckets_items "
                + "ON buckets.id = buckets_items.bucket_id "
                + "INNER JOIN items "
                + "ON items.id = buckets_items.item_id "
                + "WHERE buckets.id = ?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            List<Item> items = new ArrayList<>();
            String property = "";

            while (resultSet.next()) {
                property = resultSet.getString("property");
                items.add(new Item(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")));
            }
            return new Bucket(id, property, items);
        } catch (SQLException e) {
            logger.error("Can't get bucket by ID=" + id);
        }
        return null;
    }

    @Override
    public Bucket update(Bucket bucket) {
        String query = "UPDATE buckets SET property=? WHERE id=?;"
                + "DELETE FROM buckets_items WHERE bucket_id=?;";
        String secondQuery = "INSERT INTO buckets_items (bucket_id, item_id) VALUES (?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(query);
                PreparedStatement secondStatement = connection.prepareStatement(secondQuery)) {
            statement.setString(1, bucket.getProperty());
            statement.setLong(2, bucket.getId());
            statement.setLong(3, bucket.getId());
            statement.executeUpdate();

            for (Item item : bucket.getItems()) {
                secondStatement.setLong(1, bucket.getId());
                secondStatement.setLong(2, item.getId());
                secondStatement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error("Can't update bucket " + bucket);
        }
        return bucket;
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM buckets_items WHERE bucket_id=?;"
                + "DELETE FROM buckets WHERE id=?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can't delete bucket by ID=" + id);
        }
    }
}
