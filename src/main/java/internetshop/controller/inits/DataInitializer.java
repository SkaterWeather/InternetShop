package internetshop.controller.inits;

import internetshop.annotation.Inject;
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

        logger.info("All test data injected");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
