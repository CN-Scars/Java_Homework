package org.scars.StudentMap;

import org.scars.SetCollection.Student;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, new Student("A", 20, 1));
        studentMap.put(2, new Student("B", 21, 2));
        studentMap.put(3, new Student("C", 22, 3));
        studentMap.put(4, new Student("D", 23, 4));
        studentMap.put(5, new Student("E", 24, 5));

        for (Integer key : studentMap.keySet()) {
            System.out.println("Key: " + key + ", value: " + studentMap.get(key));
        }

        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        for (Student student : studentMap.values()) {
            if ("A".equals(student.getName())) {
                System.out.println("Found: " + student);
                break;
            }
        }

        studentMap.remove(2);

        for (Student student : studentMap.values()) {
            System.out.println(student);
        }
    }
}
