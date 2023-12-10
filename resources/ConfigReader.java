import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Получение значений по ключам
        int producerCount = Integer.parseInt(properties.getProperty("producerCount"));
        int producerTime = Integer.parseInt(properties.getProperty("producerTime"));
        int consumerCount = Integer.parseInt(properties.getProperty("consumerCount"));
        int consumerTime = Integer.parseInt(properties.getProperty("consumerTime"));
        int storageSize = Integer.parseInt(properties.getProperty("storageSize"));

        // Использование полученных значений
        System.out.println("Producer Count: " + producerCount);
        System.out.println("Producer Time: " + producerTime);
        System.out.println("Consumer Count: " + consumerCount);
        System.out.println("Consumer Time: " + consumerTime);
        System.out.println("Storage Size: " + storageSize);
    }
}