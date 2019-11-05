package internetshop.service.impl;

import internetshop.annotation.Inject;
import internetshop.annotation.Service;
import internetshop.dao.ItemDao;
import internetshop.model.Item;
import internetshop.service.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Inject
    private static ItemDao itemDao;

    @Override
    public Item create(Item item) {
        return itemDao.create(item);
    }

    @Override
    public Item get(Long id) {
        return itemDao.get(id);
    }

    @Override
    public Item update(Item item) {
        return itemDao.update(item);
    }

    @Override
    public void delete(Long id) {
        itemDao.delete(id);
    }

    @Override
    public List<Item> getAll() {
        return itemDao.getAll();
    }
}
