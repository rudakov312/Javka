package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public class Employee {
    private final int id;
    private static int globalId;
    private final LocalDate birthday;
    private final int age;
    private final Fio fio;
    private final Sex sex;
    private String post;
    private Set<String> skills;
    private final LocalDate dateOfStart;
    private BigDecimal salary;
    private boolean fired;

    public Employee(LocalDate birthday, Fio fio, Sex sex, String post, Set<String> skills, LocalDate dateOfStart, BigDecimal salary) {
        globalId++;
        this.id = globalId;
        this.birthday = birthday;
        this.age = calculateAge(birthday);
        this.fio = fio;
        this.sex = sex;
        this.post = post;
        this.skills = skills;
        this.dateOfStart = dateOfStart;
        this.salary = salary;
    }

    public int calculateAge(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthday, currentDate).getYears();
    }

    public int getId() {
        return id;
    }

    public int getAge() {

        return age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }


    public Fio getFio() {
        return fio;
    }

    public Sex getSex() {
        return sex;
    }

    public String getPost() {
        return post;
    }

    public void setPost() {
        this.post = post;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean getFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nFull Name: " + fio + "\nAge: " + age + "\nBirthday: " + birthday + "\nSex: " + sex + "\nPost: " + post + "\nSalary: " + salary + "\nSkills: " + skills + "\nDate of Start: " + dateOfStart + "\n";
    }

}
