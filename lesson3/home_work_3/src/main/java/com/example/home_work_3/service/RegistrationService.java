package com.example.home_work_3.service;

import com.example.home_work_3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private DataProcessingService dataProcessingService;

    // поля UserService, NotificationService
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    // method processRegistration
    /*создается пользователь из параметров метода*/
    public void processRegistration(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        notificationService.sendNotifications("User" + newUser + "успешно добавлен");
    }
}
