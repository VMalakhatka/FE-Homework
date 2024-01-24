package org.example.notification;

import jakarta.annotation.PreDestroy;
import org.example.todo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({"emailNotificationService",
        "smsNotificationService",
        "pushNotificationService"})
public class TaskNotification {
    NotificationService urgentN;
    NotificationService middle;
    NotificationService notUrgent;

    @Autowired
    public TaskNotification(NotificationService urgentN,
                            @Qualifier("emailNotificationService") NotificationService middle,
                            @Qualifier("smsNotificationService") NotificationService notUrgent) {
        this.urgentN = urgentN;
        this.middle = middle;
        this.notUrgent = notUrgent;
    }

    public void notification(Task task){
        if(task.getToDoTaskProperties().priority()==1) urgentN.sendNotification(task.getToDoTaskProperties().title(),
                    "Срочная задача выполните ее ");
    }

}
