package internetshop.service;

import internetshop.model.Bucket;

import java.util.List;

public interface BucketService {
    Bucket addItem(Long bucketId, Long itemId);

    Bucket clear(Long bucketId);

    List getAllItems(Long bucketId);

    Bucket create(Bucket bucket);

    Bucket get(Long id);

    Bucket update(Bucket bucket);

    void delete(Long id);

    void delete(Bucket bucket);
}
