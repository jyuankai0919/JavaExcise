package com.wjkinc;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class HashSet_ {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("abc",25000,new MyDate(1998,9,19)));
        hashSet.add(new Employee("abc",27000,new MyDate(1998,9,19)));
        hashSet.add(new Employee("abc",27000,new MyDate(1911,9,19)));
        hashSet.add(new Employee("aabbcc",27000,new MyDate(1998,9,19)));

        System.out.println(hashSet);

    }
}
class Employee{

    private String name;
    private int sal;
    private MyDate birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }
}

class MyDate{

    private int year;
    private int monty;
    private int day;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && monty == myDate.monty && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, monty, day);
    }

    @Override
    public String toString() {
        return String.format("%d-%d-%d",year,monty,day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonty() {
        return monty;
    }

    public void setMonty(int monty) {
        this.monty = monty;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int monty, int day) {
        this.year = year;
        this.monty = monty;
        this.day = day;
    }
}
