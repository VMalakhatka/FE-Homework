package org.example.todo;

import org.example.properties.ToDoTaskProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Task {
    static int countTask=1;
    private int numberOfTask;
    final private ToDoTaskProperties toDoTaskProperties;

    @Autowired
    public Task(ToDoTaskProperties toDoTaskProperties) {
        this.toDoTaskProperties = toDoTaskProperties;
        numberOfTask=countTask++;
    }

    public static int getCountTask() {
        return countTask;
    }

    public int getNumberOfTask() {
        return numberOfTask;
    }

    public ToDoTaskProperties getToDoTaskProperties() {
        return toDoTaskProperties;
    }

    @Override
    public String toString() {
        return "Task{ N-" + numberOfTask +
                " title='" + toDoTaskProperties.title() + '\'' +
                ", description='" + toDoTaskProperties.description() + '\'' +
                ", priority=" + toDoTaskProperties.priority() +
                '}';
    }
}
