package internetshop.model;

import internetshop.Generator;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Long id;
    private Long userId;
    private List<Item> items;

    public Bucket(Long userId) {
        this.id = Generator.genBucketId();
        this.userId = userId;
        this.items = new ArrayList<>();
    }

    public void deleteItem(Long itemId) {
        this.items.removeIf(s -> s.getId().equals(itemId));
    }

    public void clearItems() {
        items.clear();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
