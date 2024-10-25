package org.example.oop_exercise_6;

public class Employee {
    private final String name;
    private final double salary;
    private final String department;

    //Constructor


    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', salary=%.2f, department='%s'}",
                name, salary, department);
    }
}
