package internetshop.model;

import internetshop.Generator;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private List<Order> purchaseHistory;

    public User(String login, String password) {
        this.id = Generator.genUserId();
        this.login = login;
        this.password = password;
        this.purchaseHistory = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
