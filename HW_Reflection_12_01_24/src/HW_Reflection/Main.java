package HW_Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        myClass myObject = new myClass(42, 3.14, "Hello", true);


        try (Scanner scanner = new Scanner(System.in)) {



            Class<myClass> clazz = myClass.class;
            System.out.println("Информация о моем объекте "+clazz.getName()+" :");
            System.out.println("Поля сласса :" );
            Field[] fields=clazz.getDeclaredFields();
            Arrays.stream(fields).forEach(f -> System.out.println(f.getName()));

            Method[] methods=clazz.getDeclaredMethods();
            System.out.println("Методы класса :");
            Arrays.stream(methods).forEach(m -> System.out.println(m.getName()));
            System.out.println("Введите имя поля или метода:");
            String input = scanner.nextLine();



            try {
                clazz.getMethod(input).invoke(myObject);
            } catch (NoSuchMethodException e) {
                try {
                    Field inputField=clazz.getDeclaredField(input);
                    inputField.setAccessible(true);
                    Class<?> type=inputField.getType();
                    System.out.println("Введите число типа "+type+" для поля "+inputField.getName());
                    if (type == int.class) {
                        System.out.println("int ");
                        int i=scanner.nextInt();
                        inputField.set(myObject,i);
                    } else if (inputField.getType() == double.class) {
                        System.out.println("double ");
                        double d=scanner.nextDouble();
                        inputField.set(myObject,d);
                    } else if (inputField.getType() == boolean.class) {
                        boolean b=scanner.nextBoolean();
                       inputField.set(myObject,b);
                    } else {
                        System.out.println("Строка ");
                        String s= scanner.nextLine();
                        inputField.set(myObject,s);
                    }
                    System.out.println("Новое значение " + inputField.getName() + ": " + inputField.get(myObject) + " успешно установлено.");
                    inputField.setAccessible(false);
                } catch (Exception ex) {
                    System.out.println("Ошибка ввода .");
                }
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        }
        System.out.println("JSON :");
        System.out.println(JsonSerializer.serializeToJson(myObject));
    }

}