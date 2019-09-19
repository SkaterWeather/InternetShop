package internetshop.dao;

import internetshop.model.Item;

import java.util.List;

public interface ItemDao {
    Item create(Item item);

    Item get(Long id);

    List<Item> getAll();

    Item update(Item item);

    void delete(Long id);

    void delete(Item item);
}
