package internetshop;

import internetshop.dao.BucketDao;
import internetshop.dao.ItemDao;
import internetshop.dao.OrderDao;
import internetshop.dao.RoleDao;
import internetshop.dao.UserDao;
import internetshop.dao.hibernate.ItemDaoHibernateImpl;
import internetshop.dao.jdbc.BucketDaoJdbcImpl;
import internetshop.dao.jdbc.OrderDaoJdbcImpl;
import internetshop.dao.jdbc.RoleDaoJdbcImpl;
import internetshop.dao.jdbc.UserDaoJdbcImpl;
import internetshop.service.BucketService;
import internetshop.service.ItemService;
import internetshop.service.OrderService;
import internetshop.service.UserService;
import internetshop.service.impl.BucketServiceImpl;
import internetshop.service.impl.ItemServiceImpl;
import internetshop.service.impl.OrderServiceImpl;
import internetshop.service.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Factory {
    private static final Logger logger = Logger.getLogger(Factory.class);
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/internet-shop-data",
                    "postgres",
                    "1111");
            logger.info("DataBase connection success.");
        } catch (SQLException e) {
            logger.error("DataBase connection failure: " + e);
        }
    }

    private static ItemDao itemDaoInstance;
    private static BucketDao bucketDaoInstance;
    private static OrderDao orderDaoInstance;
    private static UserDao userDaoInstance;
    private static RoleDao roleDaoInstance;
    private static ItemService itemServiceInstance;
    private static BucketService bucketServiceInstance;
    private static OrderService orderServiceInstance;
    private static UserService userServiceInstance;

    public static ItemDao getItemDao() {
        if (itemDaoInstance == null) {
            itemDaoInstance = new ItemDaoHibernateImpl();
        }
        return itemDaoInstance;
    }

    public static BucketDao getBucketDao() {
        if (bucketDaoInstance == null) {
            bucketDaoInstance = new BucketDaoJdbcImpl(connection);
        }
        return bucketDaoInstance;
    }

    public static OrderDao getOrderDao() {
        if (orderDaoInstance == null) {
            orderDaoInstance = new OrderDaoJdbcImpl(connection);
        }
        return orderDaoInstance;
    }

    public static UserDao getUserDao() {
        if (userDaoInstance == null) {
            userDaoInstance = new UserDaoJdbcImpl(connection);
        }
        return userDaoInstance;
    }

    public static RoleDao getRoleDao() {
        if (roleDaoInstance == null) {
            roleDaoInstance = new RoleDaoJdbcImpl(connection);
        }
        return roleDaoInstance;
    }

    public static ItemService getItemService() {
        if (itemServiceInstance == null) {
            itemServiceInstance = new ItemServiceImpl();
        }
        return itemServiceInstance;
    }

    public static BucketService getBucketService() {
        if (bucketServiceInstance == null) {
            bucketServiceInstance = new BucketServiceImpl();
        }
        return bucketServiceInstance;
    }

    public static OrderService getOrderService() {
        if (orderServiceInstance == null) {
            orderServiceInstance = new OrderServiceImpl();
        }
        return orderServiceInstance;
    }

    public static UserService getUserService() {
        if (userServiceInstance == null) {
            userServiceInstance = new UserServiceImpl();
        }
        return userServiceInstance;
    }
}
