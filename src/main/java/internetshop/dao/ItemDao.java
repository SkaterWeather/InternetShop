package internetshop.dao;

import internetshop.model.Item;

import java.util.List;

public interface ItemDao {
    Item create(Item item);

    Item get(Long id);

    Item update(Item item);

    void delete(Long id);

    List<Item> getAll();
}
