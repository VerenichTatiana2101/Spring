package com.example.example3_seminar5.repository;

import com.example.example3_seminar5.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
