package com.example.tasks_home_work5.repository;

import com.example.tasks_home_work5.model.Task;
import com.example.tasks_home_work5.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}