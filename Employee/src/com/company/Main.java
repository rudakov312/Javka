package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> mySkills1 = new HashSet<>();
        mySkills1.add("Java");
        mySkills1.add("C++");
        mySkills1.add("Python");
        mySkills1.add("HTML");
        mySkills1.add("CSS");

        Set<String> mySkills2 = new HashSet<>();
        mySkills2.add("Java");
        mySkills2.add("C++");
        mySkills2.add("Pascal");

        Set<String> mySkills3 = new HashSet<>();
        mySkills2.add("Кумир");

        List<Employee> employees = List.of(
                new Employee(LocalDate.of(2000, 12, 3), new Fio("Рудаков", "Андрей", "Алексеевич"), Sex.MALE, "Безработный", mySkills1, LocalDate.of(2021, 7, 22), new BigDecimal("70000.00")),
                new Employee(LocalDate.of(2000, 12, 3), new Fio("Калаушин", "Вячеслав", "Александрович"), Sex.MALE, "Безработный", mySkills2, LocalDate.of(2021, 7, 22), new BigDecimal("70000.00")),
                new Employee(LocalDate.of(1993, 7, 12), new Fio("Белоус", "Сергей", "-"), Sex.UNDEFINED, "Директор цирка", mySkills3, LocalDate.of(2005, 7, 22), new BigDecimal("3565.17")));

        EmployeeRepository employeeRepository = new EmployeeRepository(employees);

//        System.out.println(employeeRepository);
//        System.out.println("_______________________");
//        System.out.println(employeeRepository.getByLastName("Рудаков"));
//        System.out.println(employeeRepository.getOlderThan(17));
//        System.out.println(employeeRepository.getByGender(Sex.MALE));
//        System.out.println(employeeRepository.getByStates("Безработный"));
//        System.out.println(employeeRepository.getBySalaryLessThan(10000));
//        System.out.println(employeeRepository.getBySkill("Java"));
//        System.out.println(employeeRepository.getWorkMoreThan(10));
//        System.out.println(employeeRepository.getBirthDayMates(LocalDate.of(2000,12,3)));
//        System.out.println(employeeRepository.amount());
//        System.out.println(employeeRepository.totalSalary());
//        System.out.println(employeeRepository.mapIdToEmployee());
    }
}
