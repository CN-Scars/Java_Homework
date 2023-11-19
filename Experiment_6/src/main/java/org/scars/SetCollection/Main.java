package org.scars.SetCollection;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("A", 20, 1));
        students.add(new Student("B", 21, 2));
        students.add(new Student("C", 22, 3));

        for (Student student : students) {
            System.out.println(student);
        }
    }

}
