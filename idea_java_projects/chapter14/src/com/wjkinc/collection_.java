package com.wjkinc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class collection_ {

    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(new Dog("abc",5));
        list.add(new Dog("cba",7));
        list.add(new Dog("ccc",3));


        for (Object o : list) {
            System.out.println(o);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        

    }
}

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

