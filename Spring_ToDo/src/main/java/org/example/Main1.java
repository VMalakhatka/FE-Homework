package org.example;

import org.example.config.AppConfig;
import org.example.connector.Connector;
import org.example.notification.TaskNotification;
import org.example.todo.Task;
import org.example.todo.TaskList;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        TaskList taskList = new TaskList();
        TaskNotification taskNotification=context.getBean(TaskNotification.class);
        for (int i = 0; i < 10; i++) {
            Task task=context.getBean("task", Task.class);
            taskList.addTask(task);
            taskNotification.notification(task);
        }
        System.out.println(taskList);
        System.out.println("Запустим коннект");
        Connector connector=context.getBean(Connector.class);

        context.close();
    }
}

