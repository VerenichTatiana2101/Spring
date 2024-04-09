package org.example.domain;

import org.example.interfaces.iEngine;
import org.springframework.stereotype.Component;

@Component
public class GaselineEngine implements iEngine {
    public GaselineEngine() {
        System.out.println("Создан экземпляр бензинового мотора");
    }

    @Override
    public void startEngine() {
        System.out.println("Бензиновый мотор 140. запущен");
    }
}
