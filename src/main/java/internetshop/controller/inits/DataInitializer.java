package internetshop.controller.inits;

import internetshop.annotation.Inject;
import internetshop.model.Bucket;
import internetshop.model.Item;
import internetshop.model.User;
import internetshop.service.BucketService;
import internetshop.service.ItemService;
import internetshop.service.OrderService;
import internetshop.service.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DataInitializer implements ServletContextListener {
    @Inject
    private static ItemService itemService;
    @Inject
    private static BucketService bucketService;
    @Inject
    private static OrderService orderService;
    @Inject
    private static UserService userService;

    public static final Long DEFAULT_BUCKET_ID = 0L;
    public static final Long DEFAULT_USER_ID = 0L;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // Create some items
        Item firstItem = new Item("firstItem", 9.54);
        Item secondItem = new Item("secondItem", 3.48);
        Item thirdItem = new Item("thirdItem", 10.00);
        itemService.create(firstItem);
        itemService.create(secondItem);
        itemService.create(thirdItem);

        // Create def user
        User defUser = new User("@login",
                "1111",
                "Berry",
                "Garrett");
        userService.create(defUser);

        // Create bucket (default bucket)
        Bucket defBucket = new Bucket(DEFAULT_USER_ID);
        bucketService.create(defBucket);

        // def User want to add items to bucket
        bucketService.addItem(defBucket.getId(), firstItem.getId());
        bucketService.addItem(defBucket.getId(), secondItem.getId());

        //def User wants to create Order from bucket
        orderService.completeOrder(defBucket);

        System.out.println("All test data injected");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
