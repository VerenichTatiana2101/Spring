package com.example.tasks_home_work5.model;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data //получает все необходимые методы и конструктор
@Entity //именно этот обьект нужно положить в базе данных
@Table(name = "tasks") //имя таблицы
public class Task {
    @Id //именно jakarta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;


    /**
     * Метод устанавливает текущее время задачи
     */
    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
    }
}
