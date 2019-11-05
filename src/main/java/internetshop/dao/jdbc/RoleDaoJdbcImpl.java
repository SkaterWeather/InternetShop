package internetshop.dao.jdbc;

import internetshop.annotation.Dao;
import internetshop.dao.RoleDao;
import internetshop.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;

@Dao
public class RoleDaoJdbcImpl extends AbstractDao implements RoleDao {
    private static final Logger logger = Logger.getLogger(RoleDaoJdbcImpl.class);

    public RoleDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Set<Role> getRolesByUserId(Long userId) {
        String query = "SELECT * FROM roles "
                + "INNER JOIN users_roles "
                + "ON users_roles.role_id = roles.id "
                + "WHERE user_id=?;";
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
