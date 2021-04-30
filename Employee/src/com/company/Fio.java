package com.company;

public class Fio {
    private final String name;
    private final String surname;
    private final String fatherName;

    public Fio(String surname, String name, String fatherName) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + fatherName;
    }
}
