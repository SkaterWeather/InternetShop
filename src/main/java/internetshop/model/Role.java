package internetshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleName roleName;

    public Role(Long id, String roleName) {
        this.id = id;
        setRoleName(roleName);
    }

    public Role(Long id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Role() {
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
