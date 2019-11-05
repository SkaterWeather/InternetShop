package internetshop.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Transient
    private Long userId;

    @Column(name = "total_price")
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", columnDefinition = "int4")
    private User user;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "orders_items",
            joinColumns = @JoinColumn(name = "order_id", columnDefinition = "int4"),
            inverseJoinColumns = @JoinColumn(name = "item_id", columnDefinition = "int4"))
    private List<Item> itemsList;

    public Order(Long id, Long userId, List<Item> items) {
        this.id = id;
        this.userId = userId;
        this.itemsList = new ArrayList<>(items);
        calculateTotalPrice();
    }

    public Order(User user, List<Item> items) {
        this.user = user;
        this.itemsList = new ArrayList<>(items);
        calculateTotalPrice();
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Deprecated
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void clearItems() {
        this.itemsList.clear();
    }

    @Override
    public String toString() {
        return this.id + "_userID:" + this.userId + "_" + this.totalPrice;
    }
}
