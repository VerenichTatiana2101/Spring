package org.example;

import com.google.gson.Gson;

public class PersonSerializer {
    private static final Gson gson = new Gson();

    public static String serialize(Person person) {
        return gson.toJson(person);
    }

    public static Person deserialize(String json) {
        return gson.fromJson(json, Person.class);
    }
}
