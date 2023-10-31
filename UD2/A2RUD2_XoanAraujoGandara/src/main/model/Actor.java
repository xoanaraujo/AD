package main.model;

import java.time.LocalDate;

public class Actor {
    private String id;
    private String name;
    private Sex sex;
    private LocalDate birthDate;

    public Actor(String id, String name, Sex sex, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }
}
enum Sex {
    M("Masculino"), F("Femenino");

    Sex(String femenino) {

    }
}

