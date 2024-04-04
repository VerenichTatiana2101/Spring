package org.example;
import static org.example.PersonSerializer.deserialize;
import static org.example.PersonSerializer.serialize;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Веренич", "Татьяна", 34);
        String serializedPerson = serialize(person);
        System.out.println(person);
        System.out.println(serializedPerson);

        String json = "{\"firstName\":\"Веренич\",\"lastName\":\"Татьяна\",\"age\":34}";
        Person deserializedPerson = deserialize(json);
        System.out.println(deserializedPerson);
    }
}