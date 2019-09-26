package internetshop.model;

import internetshop.Generator;

import java.util.*;

public class User {
    private final Long id;
    private final Long bucketId;
    private String token;
    private String name;
    private String surname;
    private String login;
    private String password;
    private List<Order> purchaseHistory;
    private Set<Role> roles;

    public User(String login, String password, Long bucketId) {
        this.id = Generator.genUserId();
        this.bucketId = bucketId;
        this.token = Generator.genUserToken();
        this.login = login;
        this.password = password;
        this.purchaseHistory = new ArrayList<>();
        this.roles = new HashSet<>();
        addRole(new Role(Role.RoleName.USER));
    }

    public User(String login, String password, String name, String surname, Long bucketId) {
        this.id = Generator.genUserId();
        this.bucketId = bucketId;
        this.token = Generator.genUserToken();
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.purchaseHistory = new ArrayList<>();
        this.roles = new HashSet<>();
        addRole(new Role(Role.RoleName.USER));
    }

    public Long getId() {
        return id;
    }

    public Long getBucketId() {
        return bucketId;
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

    public List<Order> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addToPurchaseHistory(Order order) {
        this.purchaseHistory.add(order);
    }

    public void deleteFromPurchaseHistory(Long orderId) {
        this.purchaseHistory.removeIf(s -> s.getId().equals(orderId));
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
