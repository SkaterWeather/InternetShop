package internetshop.dao.impl;

import internetshop.annotation.Dao;
import internetshop.dao.ImagineDateBase;
import internetshop.dao.ItemDao;
import internetshop.model.Item;

import java.util.List;
import java.util.NoSuchElementException;

@Dao
public class ItemDaoImpl implements ItemDao {

    @Override
    public Item create(Item item) {
        ImagineDateBase.itemsList.add(item);
        return item;
    }

    @Override
    public Item get(Long id) {
        return ImagineDateBase.itemsList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Item> getAll() {
        return ImagineDateBase.itemsList;
    }

    @Override
    public Item update(Item item) {
        int index = ImagineDateBase.itemsList.indexOf(item);
        ImagineDateBase.itemsList.set(index, item);
        return item;
    }

    @Override
    public void delete(Long id) {
        ImagineDateBase.itemsList.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public void delete(Item item) {
        ImagineDateBase.itemsList.removeIf(s -> s.equals(item));
    }
}
