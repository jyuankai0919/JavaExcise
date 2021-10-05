package com.wjkinc;

import java.util.HashSet;
import java.util.Iterator;

public class GenericExercise {
    public static void main(String[] args) {
        HashSet<Student> studentHashSet = new HashSet<Student>();
        studentHashSet.add(new Student("jack",22));
        studentHashSet.add(new Student("tom",25));
        studentHashSet.add(new Student("john",18));

        for (Student student : studentHashSet) {
            System.out.println(student.toString());
        }

        System.out.println("----------------");

        Iterator<Student> iterator = studentHashSet.iterator();
        while (iterator.hasNext()) {
            Student next =  iterator.next();
            System.out.println(next.toString());
        }

    }
}

class Student{

    private   String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name +"-"+ age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
