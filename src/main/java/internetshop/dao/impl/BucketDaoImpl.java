package internetshop.dao.impl;

import internetshop.annotation.Dao;
import internetshop.dao.BucketDao;
import internetshop.dao.ImagineDateBase;
import internetshop.model.Bucket;

import java.util.NoSuchElementException;

@Dao
public class BucketDaoImpl implements BucketDao {

    @Override
    public Bucket create(Bucket bucket) {
        ImagineDateBase.bucketsList.add(bucket);
        return bucket;
    }

    @Override
    public Bucket get(Long bucketId) {
        return ImagineDateBase.bucketsList.stream()
                .filter(s -> s.getId().equals(bucketId))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Bucket update(Bucket bucket) {
        int index = ImagineDateBase.bucketsList.indexOf(bucket);
        ImagineDateBase.bucketsList.set(index, bucket);
        return bucket;
    }

    @Override
    public void delete(Long id) {
        ImagineDateBase.bucketsList.removeIf(s -> s.getId().equals(id));
    }
}
