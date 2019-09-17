package internetshop.annotation;

import internetshop.Factory;
import internetshop.dao.BucketDao;
import internetshop.dao.ItemDao;
import internetshop.dao.OrderDao;
import internetshop.dao.UserDao;
import internetshop.service.BucketService;
import internetshop.service.ItemService;
import internetshop.service.OrderService;
import internetshop.service.UserService;

import java.util.Hashtable;
import java.util.Map;

public class InjectorHelper {
    private static final Map<Class, Object> objectsToInject = new Hashtable<>();

    static {
        objectsToInject.put(ItemService.class, Factory.getItemService());
        objectsToInject.put(BucketService.class, Factory.getBucketService());
        objectsToInject.put(OrderService.class, Factory.getOrderService());
        objectsToInject.put(UserService.class, Factory.getUserService());
        objectsToInject.put(ItemDao.class, Factory.getItemDao());
        objectsToInject.put(BucketDao.class, Factory.getBucketDao());
        objectsToInject.put(OrderDao.class, Factory.getOrderDao());
        objectsToInject.put(UserDao.class, Factory.getUserDao());
    }

    public static Object getFactoryImpl(Class cls) {
        return objectsToInject.get(cls);
    }
}
