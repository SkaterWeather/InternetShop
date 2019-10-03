package internetshop.dao;

import internetshop.model.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> getRolesByUserId(Long userId);
}
