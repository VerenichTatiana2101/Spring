package com.example.example2_seminar5.repository;

import com.example.example2_seminar5.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
