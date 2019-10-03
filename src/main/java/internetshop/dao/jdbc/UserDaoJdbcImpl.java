package internetshop.dao.jdbc;

import internetshop.annotation.Dao;
import internetshop.dao.UserDao;
import internetshop.model.Role;
import internetshop.model.User;
import org.apache.log4j.Logger;

import javax.naming.AuthenticationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Dao
public class UserDaoJdbcImpl extends AbstractDao<User> implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoJdbcImpl.class);

    public UserDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User create(User user) {
        String query = "INSERT INTO users (login, password, name, surname, token, bucket_id) " +
                "VALUES (?, ?, ?, ?, ?, ?);";
        String secondQuery = "INSERT INTO users_roles (user_id, role_id) VALUES (?, ?);";

        try (PreparedStatement statement =
                     connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getToken());
            statement.setLong(6, user.getBucketId());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong("id"));
                PreparedStatement secondStatement = connection.prepareStatement(secondQuery);
                for (Role role : user.getRoles()) {
                    secondStatement.setLong(1, user.getId());
                    secondStatement.setLong(2, role.getId());
                    secondStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            logger.error("Can't create user " + user);
        }
        return user;
    }

    @Override
    public User get(Long id) {
        String query = "SELECT * FROM users WHERE id=?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String token = resultSet.getString("token");
                long bucketId = resultSet.getLong("bucket_id");
                Set<Role> roles = getRolesByUserId(id);
                return new User(id, bucketId, token, name, surname, login, password, roles);
            }
        } catch (SQLException e) {
            logger.error("Can't get order by ID=" + id);
        }
        return null;
    }

    @Override
    public User update(User user) {
        String query = "UPDATE users " +
                "SET login=?, password=?, name=?, surname=?, token=?, bucket_id=? WHERE id=?; " +
                "DELETE FROM users_roles WHERE user_id=?;";
        String secondQuery = "INSERT INTO users_roles (user_id, role_id) VALUES (?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(query);
             PreparedStatement secondStatement = connection.prepareStatement(secondQuery)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setString(5, user.getToken());
            statement.setLong(6, user.getBucketId());
            statement.setLong(7, user.getId());
            statement.setLong(8, user.getId());
            statement.executeUpdate();

            for (Role role : user.getRoles()) {
                secondStatement.setLong(1, user.getId());
                secondStatement.setLong(2, role.getId());
                secondStatement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error("Can't update user " + user);
        }
        return user;
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM users_roles WHERE user_id=?;" +
                "DELETE FROM users WHERE id=?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Can't delete user by ID=" + id);
        }
    }

    @Override
    public User login(String login, String password) throws AuthenticationException {
        String query = "SELECT * FROM users WHERE login=? AND password=?;";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                long bucketId = resultSet.getLong("bucket_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String token = resultSet.getString("token");
                Set<Role> roles = getRolesByUserId(id);
                return new User(id, bucketId, token, name, surname, login, password, roles);
            } else {
                throw new AuthenticationException("Incorrect login or password");
            }
        } catch (SQLException e) {
            logger.error("Error trying to log under " + login);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        String query = "SELECT * FROM users;";
        List<User> resultList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String token = resultSet.getString("token");
                long bucketId = resultSet.getLong("bucket_id");
                Set<Role> roles = getRolesByUserId(id);
                resultList.add(new User(id, bucketId, token, name, surname, login, password, roles));
            }
        } catch (SQLException e) {
            logger.error("Can't get all users from table 'users'");
        }
        return resultList;
    }

    @Override
    public Optional<User> getByToken(String token) {
        String query = "SELECT * FROM users WHERE token=?;";
        Optional<User> user = Optional.empty();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                long bucketId = resultSet.getLong("bucket_id");
                Set<Role> roles = getRolesByUserId(id);
                user = Optional.of(new User(id, bucketId, token, name, surname, login, password, roles));
            }
        } catch (SQLException e) {
            logger.error("Can't get user by token=" + token);
        }
        return user;
    }

    private Set<Role> getRolesByUserId(Long userId) {
        String query = "SELECT * FROM roles " +
                "INNER JOIN users_roles " +
                "ON users_roles.role_id = roles.id " +
                "WHERE user_id=?;";
        Set<Role> resultRoles = new HashSet<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String roleName = resultSet.getString("role_name");
                resultRoles.add(new Role(id, roleName));
            }
        } catch (SQLException e) {
            logger.error("Can't get all roles from user by id=" + userId);
        }
        return resultRoles;
    }
}
