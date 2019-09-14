package internetshop;

public class Generator {
    private static Long genItemId;
    private static Long genUserId;
    private static Long genBucketId;
    private static Long genOrderId;

    public static Long genItemId() {
        if (genItemId == null) {
            genItemId = 0L;
        }
        return genItemId++;
    }

    public static Long genUserId() {
        if (genUserId == null) {
            genUserId = 0L;
        }
        return genUserId++;
    }

    public static Long genBucketId() {
        if (genBucketId == null) {
            genBucketId = 0L;
        }
        return genBucketId++;
    }

    public static Long genOrderId() {
        if (genOrderId == null) {
            genOrderId = 0L;
        }
        return genOrderId++;
    }
}
