package com.example.home_work_3.controllers;

import com.example.home_work_3.domain.User;
import com.example.home_work_3.service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return dataProcessingService.sortUsersByAge(
                dataProcessingService.getRepository().getUsers());
    }

    //обработчик filterUsersByAge
    @GetMapping("/filter/{age}")//localhost:8080/tasks/filter/27  пример
    public List<User> filterUsersByAge(@PathVariable int age) {
        return dataProcessingService.filterUsersByAge(
                dataProcessingService.getRepository().getUsers(), age);
    }

    //обработчик calculateAverageAge
    @GetMapping("/calc")//localhost:8080/tasks/calc
    public double calcUsersAverageAge() {
        return dataProcessingService.calculateAverageAge(
                dataProcessingService.getRepository().getUsers());
    }

    //обработчик filterUsersByAge
    @GetMapping("/filter")
    public List<User> filterUsersByParam(@RequestParam int age) {
        return dataProcessingService.filterUsersByAge(
                dataProcessingService.getRepository().getUsers(), age);
    }
}
