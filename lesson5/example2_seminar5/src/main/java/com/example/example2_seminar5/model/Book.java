package com.example.example2_seminar5.model;

import jakarta.persistence.*;
import lombok.Data;


@Data //получает все необходимые методы и конструктор
@Entity //именно этот обьект нужно положить в базе данных
@Table(name = "books") //имя таблицы
public class Book {
    @Id //именно jakarta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(name = "publication_year", nullable = false)
    private Integer publicationYear;

}
