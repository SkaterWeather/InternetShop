package internetshop.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private Long userId;
    private Double totalPrice;
    private List<Item> itemsList;

    public Order(Long id, Long userId, List<Item> items) {
        this.id = id;
        this.userId = userId;
        this.itemsList = new ArrayList<>(items);
        calculateTotalPrice();
    }

    public Order(Long userId, List<Item> items) {
        this.userId = userId;
        this.itemsList = new ArrayList<>(items);
        calculateTotalPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    private void calculateTotalPrice() {
        this.totalPrice = itemsList.stream().mapToDouble(Item::getPrice).sum();
    }
}
