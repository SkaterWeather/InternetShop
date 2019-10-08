package internetshop.controller.inits;

import internetshop.annotation.Injector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

public class InjectInitializer implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(InjectInitializer.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            Injector.injectDependencies();
            logger.info("All dependencies injected");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
