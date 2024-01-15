import reflect.EventHandler;
import reflect.ReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Class<?>> listClasses = ReflectionHelper.findAnnotations("handlers", EventHandler.class);
        System.out.println(listClasses);
        System.out.println(crateInstances(listClasses,"Crate Instances"));
    }
    private static List<?> crateInstances(List<Class<?>> listClasses,String type) {
        return listClasses.stream()
                .map(c -> {
                    try {
                        System.out.println(c);
                        return c.getConstructor(String.class).newInstance(type);
                    } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}