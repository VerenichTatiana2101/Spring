package com.example.MyWebApplication;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {

    public Task(String name, String description) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }

    public Task() {
    }

    public void setCompletionTime(LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public enum Status {
        TO_DO,
        IN_PROGRESS,
        DONE
    }

    private UUID id;
    private String name;
    private String description;
    private Status status;
    private LocalDateTime completionTime;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCompletionTime() {
        return completionTime;
    }
}
