package org.scars.TreeSet;

import java.util.Objects;
import java.util.TreeSet;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int seatNumber;

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.seatNumber, o.seatNumber);
    }


    public Student(String name, int age, int seatNumber) {
        this.name = name;
        this.age = age;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", seatNumber=" + seatNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return seatNumber == student.seatNumber;

    }

    @Override
    public int hashCode() {
        return Objects.hash(seatNumber);
    }

    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("A", 20, 1));
        students.add(new Student("B", 21, 2));
        students.add(new Student("C", 22, 3));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
