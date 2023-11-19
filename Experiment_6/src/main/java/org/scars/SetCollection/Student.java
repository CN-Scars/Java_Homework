package org.scars.SetCollection;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private int seatNumber;

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

    public String getName() {
        return name;
    }
}
