package org.example;

import org.example.config.ProjectConfig;
import org.example.domain.Car;
import org.example.domain.Engine;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Car simpleCar1 = context.getBean(Car.class);
        System.out.println(simpleCar1);

        Engine engine1 = context.getBean(Engine.class);
        System.out.println(engine1);

    }
}