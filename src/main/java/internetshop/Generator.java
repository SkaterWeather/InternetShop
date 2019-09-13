package internetshop;

public class Generator {
    private static Long itemId;
    private static Long userId;
    private static Long bucketId;
    private static Long orderId;

    public static Long genItemId() {
        if (itemId == null) {
            itemId = 0L;
        }
        return itemId++;
    }

    public static Long genUserId() {
        if (userId == null) {
            userId = 0L;
        }
        return userId++;
    }

    public static Long genBucketId() {
        if (bucketId == null) {
            bucketId = 0L;
        }
        return bucketId++;
    }

    public static Long genOrderId() {
        if (orderId == null) {
            orderId = 0L;
        }
        return orderId++;
    }
}
