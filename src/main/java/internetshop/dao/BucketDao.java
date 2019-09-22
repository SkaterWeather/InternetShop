package internetshop.dao;

import internetshop.model.Bucket;

public interface BucketDao {
    Bucket create(Bucket bucket);

    Bucket get(Long bucketId);

    Bucket getByUserId(Long userId);

    Bucket update(Bucket bucket);

    void delete(Long id);

    void delete(Bucket bucket);
}
