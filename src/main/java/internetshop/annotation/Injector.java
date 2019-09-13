package internetshop.annotation;

import internetshop.Factory;
import internetshop.Main;
import internetshop.dao.BucketDao;
import internetshop.dao.ItemDao;
import internetshop.dao.OrderDao;
import internetshop.dao.UserDao;
import internetshop.service.BucketService;
import internetshop.service.ItemService;
import internetshop.service.OrderService;
import internetshop.service.UserService;
import internetshop.service.impl.BucketServiceImpl;
import internetshop.service.impl.ItemServiceImpl;
import internetshop.service.impl.OrderServiceImpl;
import internetshop.service.impl.UserServiceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Injector {
    private static List<Class> services = new ArrayList<>();
    private static Map<Class, Object> objectsToInject = new Hashtable<>();

    static {
        services.add(Main.class);
        services.add(ItemServiceImpl.class);
        services.add(BucketServiceImpl.class);
        services.add(OrderServiceImpl.class);
        services.add(UserServiceImpl.class);
        objectsToInject.put(ItemService.class, Factory.getItemService());
        objectsToInject.put(BucketService.class, Factory.getBucketService());
        objectsToInject.put(OrderService.class, Factory.getOrderService());
        objectsToInject.put(UserService.class, Factory.getUserService());
        objectsToInject.put(ItemDao.class, Factory.getItemDao());
        objectsToInject.put(BucketDao.class, Factory.getBucketDao());
        objectsToInject.put(OrderDao.class, Factory.getOrderDao());
        objectsToInject.put(UserDao.class, Factory.getUserDao());
    }

    public static void injectDependencies() throws IllegalAccessException {
        for (Class currentServiceClass : services) {
            for (Field field : currentServiceClass.getDeclaredFields()) {

                if (field.getDeclaredAnnotation(Inject.class) != null
                        && objectsToInject.containsKey(field.getType())
                        && (objectsToInject.get(field.getType()).getClass()
                        .getDeclaredAnnotation(Service.class) != null
                        || objectsToInject.get(field.getType()).getClass()
                        .getDeclaredAnnotation(Dao.class) != null)) {
                    field.setAccessible(true);
                    field.set(null, objectsToInject.get(field.getType()));
                }
            }
        }
    }
}
