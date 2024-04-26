package com.example.example3_seminar5.repository;

import com.example.example3_seminar5.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
