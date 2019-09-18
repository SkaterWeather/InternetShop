package internetshop;

import internetshop.annotation.Inject;
import internetshop.annotation.Injector;
import internetshop.annotation.Service;
import internetshop.model.Bucket;
import internetshop.model.Item;
import internetshop.model.User;
import internetshop.service.BucketService;
import internetshop.service.ItemService;
import internetshop.service.OrderService;
import internetshop.service.UserService;

@Service
public class Main {
    @Inject
    private static ItemService itemService;
    @Inject
    private static BucketService bucketService;
    @Inject
    private static OrderService orderService;
    @Inject
    public static UserService userService;

    static {
        try {
            Injector.injectDependencies();
        } catch (IllegalAccessException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //1. Create some items
        Item firstItem = new Item("firstItem", 9.54);
        Item secondItem = new Item("secondItem", 3.48);
        itemService.create(firstItem);
        itemService.create(secondItem);

        //2. Create new user
        User testUser = new User("login", "safest_pass123");
        Long testUserId = testUser.getId();
        userService.create(testUser);

        //3. Add item into user's bucket
        Bucket userBucket = new Bucket(testUserId);
        bucketService.create(userBucket);
        bucketService.addItem(userBucket.getId(), firstItem.getId());

        //4. User wants to create Order from bucket
        orderService.completeOrder(userBucket);
        bucketService.delete(userBucket);

        //5. User wants to see purchase history
        userService.get(testUserId).getPurchaseHistory().forEach(System.out::println);
    }
}
