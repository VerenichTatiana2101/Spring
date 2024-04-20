package com.example.home_work_3.controllers;

import com.example.home_work_3.domain.User;
import com.example.home_work_3.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public RegistrationService registrationService;

    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    // получаем пользователя конвертируем в объект User
    public String userAddFromBody(@RequestBody User user) {
        registrationService.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body";
    }

    /**
     * обработчик userAddFromParam извлекающий данные для
     * создания пользователя из параметров HTTP запроса
     */
    public String userAddFromParams(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") int age,
            @RequestParam(defaultValue = "") String email){
        registrationService.processRegistration(name, age, email);
        return "User" + name + "added from param";
    }
}
