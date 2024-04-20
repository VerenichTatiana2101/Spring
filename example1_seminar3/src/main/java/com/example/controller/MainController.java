package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // добавляем в карту обработчиков
    @RequestMapping("/home")
    public String getHome(){
        return "home.html";
    }

    @RequestMapping("/cats")
    public String getCats(){
        return "cats.html";
    }

    @RequestMapping("/game")
    public String getGame(){
        return "game.html";
    }
}
