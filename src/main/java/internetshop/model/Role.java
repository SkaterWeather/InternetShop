package internetshop.model;

import internetshop.Generator;

public class Role {
    private final Long id;
    private RoleName roleName;

    public Role() {
        this.id = Generator.genRoleId();
    }

    public Role(RoleName roleName) {
        this.id = Generator.genRoleId();
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public enum RoleName {
        USER, ADMIN;
    }
}
