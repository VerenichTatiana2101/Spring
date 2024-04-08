package org.example.domain;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    private String typeEngin = "Бензиновый";

    /*
    public Engine() {
        System.out.println("Двигатель создан!");
    }*/

    public String getTypeEngine() {
        return typeEngin;
    }

    public void setTypeEngine(String typeEngin) {
        this.typeEngin = typeEngin;
    }

    @Override
    public String toString() {
        return "Engine='" + typeEngin + '\'';
    }
}
