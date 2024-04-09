package com.example.MyFirstCrud.services;

import com.example.MyFirstCrud.model.User;
import com.example.MyFirstCrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Удаление пользователя через репозиторий
     * @param id
     */
    public void deleteById(int id){
        userRepository.deleteById(id);
    }


    /**
     * Получение пользователя через репозиторий
     * @param id
     */
    public User getOne(int id) {
        return userRepository.getById(id);
    }

    /**
     * Обновление данных пользователя
     */
    public void update(User user) {
        userRepository.update(user);
    }
}