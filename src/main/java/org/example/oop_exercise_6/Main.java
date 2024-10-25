package org.example.oop_exercise_6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // List of Employee objects
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 75000, "Engineering"),
                new Employee("Bob", 50000, "Marketing"),
                new Employee("Charlie", 85000, "Engineering"),
                new Employee("David", 45000, "Sales"),
                new Employee("Eve", 65000, "Marketing")
        );

        Comparator<Employee> comparator = new NameComparator();
        // 1. Sort the employees by salary using a custom comparator
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Sorted Employees by Salary:");
        employees.forEach(System.out::println);

        // 2. Use Stream API to filter, transform, and process the sorted list
        List<String> highEarners = employees.stream()
                .sorted(comparator)
                .filter(emp -> emp.getSalary() > 60000)
                .map(Employee::getName)
                .toList();

        System.out.println("\nEmployees with Salary > 60000 (Sorted by Name):");
        highEarners.forEach(System.out::println);
    }
}
