package com.example.acquaintance.domain;

import com.example.acquaintance.Engine;
import org.springframework.stereotype.Service;

@Service
public class Car {
    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.go();
    }
}
