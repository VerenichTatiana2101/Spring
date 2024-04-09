package org.example.domain;

import org.example.interfaces.iEngine;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DieselEngine implements iEngine {
    public DieselEngine() {
        System.out.println("Создан экземпляр дизельного мотора");
    }

    @Override
    public void startEngine() {
        System.out.println("Дизельный мотор 115л.с. запущен");
    }

    @Override
    public String toString() {
        return "DieselEngine{}";
    }
}
