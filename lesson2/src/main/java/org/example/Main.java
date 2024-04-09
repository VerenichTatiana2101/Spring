package org.example;

import org.example.config.ProjectConfig;
import org.example.domain.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
/*
        Car myCar = new Car();
        myCar.setModel("X1");
        myCar.setMade("BMW");
        System.out.println(myCar);
*/
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Car simpleCar1 = context.getBean(Car.class);
        System.out.println(simpleCar1);

        String s = context.getBean(String.class);
        System.out.println(s);

        Integer num = context.getBean(Integer.class);
        System.out.println(num);

        Car simpleCar2 = context.getBean("BMW", Car.class);
        System.out.println(simpleCar2);
    }
}