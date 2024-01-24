package org.example.todo;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Task List:\n");

        for (int i = 0; i < tasks.size(); i++) {
            result.append("Task ").append(i + 1).append(": ").append(tasks.get(i)).append("\n");
        }

        return result.toString();
    }
    }
