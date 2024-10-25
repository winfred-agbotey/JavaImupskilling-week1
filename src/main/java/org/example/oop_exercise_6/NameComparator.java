package org.example.oop_exercise_6;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee first, Employee second) {
        return first.getName().compareTo(second.getName());
    }
}
