package com.example.MyFirstCrud.controller;

import com.example.MyFirstCrud.model.User;
import com.example.MyFirstCrud.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Перехват команды на удаление студента от браузера
     *
     * @param id номер пользователя
     * @return обновлённый список
     */
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    /**
     * Метод при нажатии на кнопку выводит заполненную форму для изменения
     *
     * @param model
     * @param id    user id
     * @return
     */
    @GetMapping("/user-update/{id}")
    public String updateUserByID(Model model, @PathVariable int id) {
        User user = userService.getOne(id);
        if (user == null) return "redirect:/users";
        System.out.println(user);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Метод обновления данных
     *
     * @param user
     * @return
     */
    @PostMapping("/user-update/{id}")
    public String updateUser(User user) {
        userService.update(user);
        return "redirect:/users";
    }

}