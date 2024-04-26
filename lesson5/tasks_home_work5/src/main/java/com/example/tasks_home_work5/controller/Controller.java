package com.example.tasks_home_work5.controller;

import com.example.tasks_home_work5.model.Task;
import com.example.tasks_home_work5.model.TaskStatus;
import com.example.tasks_home_work5.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class Controller {
    private final TaskService taskService;

    /**
     * Добавление задачи.
     * @param task Задача для добавления.
     * @return Добавленная задача.
     * POST http://localhost:8080/tasks
     *{
     *     "description": "Android lecture",
     *     "status": "NOT_STARTED"
     * }
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    /**
     * @return Список всех задач.
     * GET http://localhost:8080/tasks
     */
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    /**
     * Обновляет статус задачи по ID.
     * @param id id задачи
     * @param task задача
     * @return обновленная задача
     * PUT http://localhost:8080/tasks/1
     * {
     * "status": "COMPLETED"
     * }
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTaskStatus(id, task);
    }

    /**
     * Возвращает список задач в соответствии со статусом.
     * @param status статус
     * GET http://localhost:8080/tasks/status/NOT_STARTED
     **/
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByStatus(status);
    }

    /**
     * Удаляет задачу по идентификатору.
     * @param id id задачи
     * DELETE http://localhost:8080/tasks/1
     */
    @DeleteMapping("/{id}")
    public  void deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
    }

    /**
     * Поиск задачи по ID.
     * @param id id задачи
     * @return задачу
     * GET http://localhost:8080/tasks/id/1
     */
    @GetMapping("/id/{id}")
    public Task getTasksById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

//    @PutMapping("/{id}")
//    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
//        return taskService.updateTask(id, task);
//    }

}
