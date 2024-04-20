package com.example.MyWebApplication;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public Task getTask(UUID uuid) {
        return tasks.stream().filter(
                        t -> t.getId().equals(uuid))
                .findFirst().orElse(null);

    }

    public Task addTask(Task task){
        tasks.add(task);
        return task;
    }

    public void deleteTask(UUID uuid){
        tasks.removeIf(t-> t.getId().equals(uuid));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    //обновление задачи
    public Task updateTask(UUID uuid, Task task){
        Task newTask = getTask(uuid);
        if (task!= null){
            newTask.setDescription(task.getDescription());
            newTask.setName(task.getName());
            newTask.setCompletionTime(task.getCompletionTime());
        }
        return newTask;
    }
}

