package com.example.home_work_3.service;

import com.example.home_work_3.domain.User;
import org.springframework.stereotype.Service;

// используется для уведомлений, логирования
@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void sendNotifications(String s) {
        System.out.println(s);
    }
}
