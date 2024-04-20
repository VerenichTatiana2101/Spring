package com.example.MyWebApplication;

import org.apache.coyote.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    private List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    // получение по id
    @GetMapping("/{id}")
    private Task getById(@PathVariable UUID id){
        return taskService.getTask(id);
    }

    // добавление
    @PostMapping()
    private Task addById(@RequestBody Task task ){
        return taskService.addTask(task);
    }

    // удаление
    @DeleteMapping("/{id}")
    private void removeById(@PathVariable UUID id){
        taskService.deleteTask(id);
    }

    // обновление
    @PutMapping("/{id}")
    private Task updateById(@PathVariable UUID id, @RequestBody Task task ){
        return taskService.updateTask(id, task);
    }
}
