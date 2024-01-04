package ConcurentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> hashMap = new ConcurrentHashMap<>();
        hashMap.put("key", 5);
        hashMap.put("key1", 6);

        updateValue(hashMap, "key");

        System.out.println("Текущее " + hashMap.get("key"));
    }

    private static void updateValue(ConcurrentMap<String, Integer> stockMap, String key) {
        stockMap.compute(key, (k, v) -> {
            if(v != null && v > 0) --v;
            return v;
        });
        }
}
