package com.example.controllers;


import com.example.model.Student;
import com.example.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
public class StudentsController {

    private final StudentRepository studentRepository;

    @GetMapping("/students")
    public String getStudent(Model model) {
        model.addAttribute("students",studentRepository.getStudents());
        return "students.html";
    }

    @PostMapping("/students")
    public String addStudent(Student student, Model model) {
        studentRepository.addStudent(student);
        model.addAttribute("students",studentRepository.getStudents());
        return "students.html";
    }
}