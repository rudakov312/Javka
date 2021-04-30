package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.math.BigDecimal.valueOf;

public class EmployeeRepository {

    private final List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Найти всех сотрудников с заданной фамилией
     */
    public List<Employee> getByLastName(String lastName) {
        List<Employee> result = new LinkedList<Employee>();
        for (var current : employees) {
            if (lastName.equals(current.getFio().getSurname())) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников старше заданного возраста
     */
    public List<Employee> getOlderThan(int age) {
        List<Employee> result = new LinkedList<Employee>();
        for (var current : employees) {
            if (age < current.getAge()) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников заданного пола.
     * Вместо Object используйте ваш класс для пола
     */
    public List<Employee> getByGender(Sex sex) {
        List<Employee> result = new LinkedList<Employee>();
        for (var current : employees) {
            if (sex == current.getSex()) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников с указанными должностями
     */
    public List<Employee> getByStates(String... states) {
        List<Employee> result = new LinkedList<Employee>();
        for (int counter = states.length; counter != 0; counter--) {
            for (var current : employees) {
                int size = employees.size() - 1;
                if (states[counter - 1].equals(current.getPost())) {
                    result.add(current);
                }
                size--;
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников с зарплатой меньше заднной в рублях
     */
    public List<Employee> getBySalaryLessThan(int salaryInRubbles) {
        List<Employee> result = new LinkedList<Employee>();
        int sizeOfList = employees.size() - 1;
        for (var current : employees) {
            if (current.getSalary().compareTo(valueOf(salaryInRubbles)) == -1) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников, обладающих заданным навыком
     */
    public List<Employee> getBySkill(String skill) {
        List<Employee> result = new LinkedList<Employee>();
        for (var current : employees) {
            if (current.getSkills().contains(skill)) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников, работающих в компании больше заданного числа лет
     */
    public List<Employee> getWorkMoreThan(int years) {
        List<Employee> result = new LinkedList<Employee>();
        LocalDate currentDate = LocalDate.now();
        for (var current : employees) {
            if (Period.between(current.getDateOfStart(), currentDate).getYears() > years) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Найти всех сотрудников, у которых День рождения в указанную дату
     */
    public List<Employee> getBirthDayMates(LocalDate date) {
        List<Employee> result = new LinkedList<Employee>();
        for (var current : employees) {
            if (date.equals(current.getBirthday())) {
                result.add(current);
            }
        }
        return result;
    }

    /**
     * Получить сколько всего сотрудников работает в компании
     */
    public int amount() {
        return employees.size();
    }

    /**
     * Получить сколько всего денег тратит компания на зарплаты в год.
     * Вместо Object используйте подходящий тип данных
     */
    public BigDecimal totalSalary() {
        BigDecimal summary = valueOf(0);
        for (var current : employees) {
            summary = summary.add(current.getSalary());
        }
        return summary;
    }

    /**
     * Получить отображение идентификатора работника на сущность работника для удобства дальнейшего поиска по id
     */
    public Map<Integer, Employee> mapIdToEmployee() {
        Map<Integer, Employee> mapOfEmployees = new HashMap<>();
        for (var current : employees) {
            mapOfEmployees.put(current.getId(), current);
        }
        return mapOfEmployees;
    }

    @Override
    public String toString() {
        return employees.toString();
    }
}
