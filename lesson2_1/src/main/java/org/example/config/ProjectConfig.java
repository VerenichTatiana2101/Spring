package org.example.config;

import org.example.domain.Car;
import org.example.domain.Engine;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
public class ProjectConfig {

    /*
    @Bean
    Engine engine1() {
        Engine eng = new Engine();
        eng.setTypeEngine("Бензиновый");
        return eng;
    }


    @Bean("BMW")
    Car car1() {
        Car obCar = new Car(engine1());
        obCar.setModel("X1");
        obCar.setMade("BMW");
        return obCar;
    }*/

}
