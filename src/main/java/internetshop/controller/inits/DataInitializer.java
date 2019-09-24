package internetshop.controller.inits;

import internetshop.annotation.Inject;
import internetshop.model.Bucket;
import internetshop.model.Item;
import internetshop.model.User;
import internetshop.service.BucketService;
import internetshop.service.ItemService;
import internetshop.service.OrderService;
import internetshop.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DataInitializer implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(DataInitializer.class);
    @Inject
    private static ItemService itemService;
    @Inject
    private static BucketService bucketService;
    @Inject
    private static OrderService orderService;
    @Inject
    private static UserService userService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Item firstItem = new Item("firstItem", 9.54);
        Item secondItem = new Item("secondItem", 3.48);
        Item thirdItem = new Item("thirdItem", 10.00);
        itemService.create(firstItem);
        itemService.create(secondItem);
        itemService.create(thirdItem);

        Bucket defBucket = new Bucket();
        bucketService.create(defBucket);

        User defUser = new User("@login",
                "1111",
                "Berry",
                "Garrett",
                defBucket.getId());
        userService.create(defUser);

        bucketService.addItem(defBucket.getId(), firstItem.getId());
        bucketService.addItem(defBucket.getId(), secondItem.getId());

        orderService.completeOrder(defUser.getId());

        logger.info("All test data injected");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
