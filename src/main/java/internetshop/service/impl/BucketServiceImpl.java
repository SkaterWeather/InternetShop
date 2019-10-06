package internetshop.service.impl;

import internetshop.annotation.Inject;
import internetshop.annotation.Service;
import internetshop.dao.BucketDao;
import internetshop.dao.ItemDao;
import internetshop.model.Bucket;
import internetshop.model.Item;
import internetshop.service.BucketService;

@Service
public class BucketServiceImpl implements BucketService {
    @Inject
    private static BucketDao bucketDao;
    @Inject
    private static ItemDao itemDao;

    @Override
    public Bucket addItem(Long bucketId, Long itemId) {
        Bucket bucket = bucketDao.get(bucketId);
        Item item = itemDao.get(itemId);
        bucket.getItems().add(item);
        return bucketDao.update(bucket);
    }

    @Override
    public Bucket deleteItem(Long bucketId, Long itemId) {
        Bucket bucket = bucketDao.get(bucketId);
        bucket.deleteItem(itemId);
        return bucketDao.update(bucket);
    }

    @Override
    public Bucket create(Bucket bucket) {
        return bucketDao.create(bucket);
    }

    @Override
    public Bucket get(Long id) {
        return bucketDao.get(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketDao.update(bucket);
    }

    @Override
    public void delete(Long id) {
        bucketDao.delete(id);
    }
}
