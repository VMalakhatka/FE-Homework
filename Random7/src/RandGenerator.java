import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandGenerator {
    public static int rand5() {
        Random random = new Random();
        return random.nextInt(5);
    }

    public static int rand7() {
        while (true) {
            int num = 5 * rand5() + rand5();
            if (num < 21) {
                return num % 7;
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        int rand=0;
        for (int i = 0; i < 10000000; i++) {
            rand=rand7();
          map.merge(rand,1,(a,b)->b+a);
        }
        System.out.println(map);
    }
}