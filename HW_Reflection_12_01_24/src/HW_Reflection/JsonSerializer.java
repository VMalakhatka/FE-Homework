package HW_Reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer {

    public static String serializeToJson(Object object) {
        Map<String, Object> jsonMap = new HashMap<>();

        try {
            Class<?> clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                jsonMap.put(field.getName(), field.get(object));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // Ну типа JSON
        String s="";
        for (Map.Entry<String,Object> entry:jsonMap.entrySet()) {
            s+="(" + entry.getKey() + ")" + "{" + entry.getValue() + "}";
        }
        return s;
    }}