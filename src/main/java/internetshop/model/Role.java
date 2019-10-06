package internetshop.model;

public class Role {
    private Long id;
    private RoleName roleName;

    public Role(Long id, String roleName) {
        this.id = id;
        setRoleName(roleName);
    }

    public Role(Long id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public void setRoleName(String roleName) {
        if (roleName.equals("USER")) {
            this.roleName = RoleName.USER;
        }
        if (roleName.equals("ADMIN")) {
            this.roleName = RoleName.ADMIN;
        }
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public enum RoleName {
        USER, ADMIN;
    }
}
