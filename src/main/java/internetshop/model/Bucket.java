package internetshop.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "buckets")
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    private String property;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "buckets_items",
            joinColumns = @JoinColumn(name = "bucket_id", columnDefinition = "int4"),
            inverseJoinColumns = @JoinColumn(name = "item_id", columnDefinition = "int4"))
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

    @Override
    public String toString() {
        return this.id + "_" + this.items;
    }
}
