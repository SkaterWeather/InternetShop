package internetshop.model;

import internetshop.Generator;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private final Long id;
    private List<Item> items;

    public Bucket() {
        this.id = Generator.genBucketId();
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

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
