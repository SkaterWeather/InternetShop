package internetshop.annotation;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Injector {
    private static final Logger logger = Logger.getLogger(Injector.class);
    private static final String PROJECT_MAIN_PACKAGE = "internetshop";
    private static List<Class> classes = new ArrayList<>();

    static {
        try {
            classes.addAll(getClasses(PROJECT_MAIN_PACKAGE));
        } catch (ClassNotFoundException | IOException e) {
            logger.error("Error trying to get all classes from internetshop package.");
        }
    }

    public static void injectDependencies() throws IllegalAccessException {
        for (Class currentClass : classes) {
            for (Field field : currentClass.getDeclaredFields()) {
                if (field.getDeclaredAnnotation(Inject.class) != null) {
                    Object implementation = InjectorHelper.getFactoryImpl(field.getType());
                    if (implementation.getClass().getDeclaredAnnotation(Service.class) != null
                            || implementation.getClass().getDeclaredAnnotation(Dao.class) != null) {
                        field.setAccessible(true);
                        field.set(null, implementation);
                    }
                }
            }
        }
    }

    private static List<Class> getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName)
            throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    assert !file.getName().contains(".");
                    classes.addAll(findClasses(file, packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    String className = packageName + '.'
                            + file.getName().substring(0, file.getName().length() - 6);
                    classes.add(Class.forName(className));
                }
            }
        }
        return classes;
    }
}
