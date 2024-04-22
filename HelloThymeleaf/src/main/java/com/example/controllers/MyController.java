package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class MyController {
    Random rnd = new Random();
    // добавляем в карту обработчиков
//    @RequestMapping("/about")
//    public String getAbout() {
//        return "about.html";
//    }

    @GetMapping("/random")
    public String getRandom(Model model) {
        int num = rnd.nextInt(100);
        model.addAttribute("number", num);
        return "random";
    }

    /*
    * Запрос в виде
    * http://localhost:8080/random/10/30
    * */
    @GetMapping("/random/{min}/{max}")
    public String getMinMaxRandom(Model model, @PathVariable(name = "min") int min, @PathVariable(name = "max") int max) {
        int num = rnd.nextInt(min, max);
        model.addAttribute("number", num);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "minMaxRandom";
    }

    /*
     * Запрос в виде
     * http://localhost:8080/randomPath?min=10&max=56
     * */
    @GetMapping("/randomPath")
    public String getPathRandom(Model model, @RequestParam(name = "min") int min, @RequestParam(name = "max") int max) {
        Random rnd = new Random();
        int num = rnd.nextInt(min, max);
        model.addAttribute("number",num);
        model.addAttribute("min",min);
        model.addAttribute("max",max);
        return "minMaxRandom";
    }

}
