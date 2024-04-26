package com.example.tasks_home_work5.service;

import com.example.tasks_home_work5.model.Task;
import com.example.tasks_home_work5.model.TaskStatus;
import com.example.tasks_home_work5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    /**
     * Список всех задач.
     *
     * @return Список всех задач.
     */
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    /**
     * Получает задачу по id
     * @param id id задачи
     */
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    /**
     * Получает задачи по статусу.
     *
     * @param status статус задач для выборки.
     * @return список задач
     */
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    /**
     * Добавляет новую задачу.
     *
     * @param task Задача для добавления.
     * @return Добавленная задача.
     */
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    /**
     * Удаляет задачу по ID.
     *
     * @param id id задачи для удаления.     *
     */
    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }

//    /**
//     * Полное бновление задачи
//     * @param id id задачи
//     * @param taskDetails задача
//     * @return обновлённую задачу
//     */
//    public Task updateTask(Long id, Task taskDetails){
//        Optional<Task> optionalTask = taskRepository.findById(id);
//        if (optionalTask.isPresent()) {
//            Task task = optionalTask.get();
//            task.setDescription(taskDetails.getDescription());
//            task.setStatus(taskDetails.getStatus());
//            task.setCreateDate(taskDetails.getCreateDate());
//            return taskRepository.save(task);
//        } else {
//            throw new IllegalArgumentException("task not found with id: " + id);
//        }
//    }

    /**
     * Обновляет статус задачи по ID.
     *
     * @param id  id задачи для обновления.
     * @param updatedTask  Задачa с новыми данными.
     * @return Обновленная задача.
     */
    public Task updateTaskStatus(Long id, Task updatedTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with id: " + id));
        task.setStatus(updatedTask.getStatus());
        return taskRepository.save(task);
    }
}