package internetshop.controller.inits;

import internetshop.annotation.Inject;
import internetshop.model.Bucket;
import internetshop.model.Item;
import internetshop.model.Role;
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
        //testing itemDaoJdbcImpl.class
        Item defItem = new Item("Sword", 9.54);
        logger.info("Item put into DB: " + itemService.create(defItem));
        logger.info("Item got from DB: " + itemService.get(defItem.getId()));
        defItem.setName("Axe");
        itemService.update(defItem);
        logger.info("Item updated into DB: " + itemService.get(defItem.getId()));
        itemService.delete(defItem.getId());
        logger.info("Item deleted from DB");

        Bucket defBucket = new Bucket();
        bucketService.create(defBucket);
        User defUser = new User("@login",
                "1111",
                "Berry",
                "Garrett",
                defBucket.getId());
        defUser.addRole(new Role(Role.RoleName.ADMIN));
        userService.create(defUser);
        logger.info("All test data injected");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
