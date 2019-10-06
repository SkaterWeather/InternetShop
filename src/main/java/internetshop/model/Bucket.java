package internetshop.model;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Long id;
    private String property;
    private List<Item> items;

    public Bucket(Long id, String property, List<Item> items) {
        this.id = id;
        this.property = property;
        this.items = items;
    }

    public Bucket() {
        this.property = "DEFAULT";
        this.items = new ArrayList<>();
    }

    public void deleteItem(Long itemId) {
        this.items.removeIf(s -> s.getId().equals(itemId));
    }

    public void clearItems() {
        this.items.clear();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
