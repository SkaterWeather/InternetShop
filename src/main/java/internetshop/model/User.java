package internetshop.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {
    private Long id;
    private Long bucketId;
    private String token;
    private String name;
    private String surname;
    private String login;
    private String password;
    private byte[] salt;
    private Set<Role> roles;

    public User(Long id, Long bucketId, String token,
                String name, String surname, String login, String password, byte[] salt) {
        this.id = id;
        this.bucketId = bucketId;
        this.token = token;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.salt = salt;
    }

    public User(String login, String password, byte[] salt,
                String name, String surname, Long bucketId) {
        this.bucketId = bucketId;
        this.token = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.salt = salt;
        this.roles = new HashSet<>();
        addRole(new Role(1L, Role.RoleName.USER));
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    public Long getBucketId() {
        return bucketId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return name + "_" + surname;
    }
}
