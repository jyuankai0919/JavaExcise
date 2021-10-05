package com.wjkinc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("jack",25000.0,new MyDate(9,10,1998)));
        list.add(new Employee("jack",25500.0,new MyDate(9,10,1997)));
        list.add(new Employee("tom",29000.0,new MyDate(7,10,1997)));
        list.add(new Employee("smith",155000.0,new MyDate(12,10,1995)));
        list.add(new Employee("smith",155000.0,new MyDate(10,10,1995)));
        list.add(new Employee("smith",155000.0,new MyDate(9,10,1995)));
        list.add(new Employee("apple",255000.0,new MyDate(9,10,1992)));
        list.add(new Employee("apple",255000.0,new MyDate(6,10,1988)));
        list.add(new Employee("apple",255000.0,new MyDate(8,10,1977)));
        list.add(new Employee("apple",255000.0,new MyDate(9,9,1992)));

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int nameResult = o1.getName().compareTo(o2.getName());
                if(nameResult != 0 ){
                    return nameResult;
                }

                return o1.getBirthday().compareTo(o2.getBirthday());


//                if (o1.getBirthday().getYear()-o2.getBirthday().getYear()>0){
//                    return 1;
//                }else if (o1.getBirthday().getYear()-o2.getBirthday().getYear()<0){
//                    return -1;
//                }else{
//                    return 0;
//                }
            }
        });


//        for (int i = 0; i < list.size()-1; i++) {
//            for (int j = i+1; j < list.size(); j++) {
//                if (list.get(i).getName().equals(list.get(j).getName())){
//
//                    if (list.get(i).getBirthday().getYear()>list.get(j).getBirthday().getYear()){
//                        Collections.swap(list,i,j);
//                    }else if (list.get(i).getBirthday().getMonth()>list.get(j).getBirthday().getMonth()){
//                        Collections.swap(list,i,j);
//                    }else if (list.get(i).getBirthday().getDay()>list.get(j).getBirthday().getDay()){
//                        Collections.swap(list,i,j);
//                    }
//
//                }
//            }
//        }
        for (Employee employee : list) {
            System.out.println(employee.toString());
        }


    }
}

class Employee{
    private String name;
    private Double sal;
    private MyDate birthday;

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, Double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }
}




class MyDate implements Comparable<MyDate> {
    private int month;
    private int day;
    private int year;

    @Override
    public String toString() {
        return year+"-"+month+"-"+day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public int compareTo(MyDate o) {
        int yearResult = year - o.getYear();
        if (yearResult != 0){
            return yearResult;
        }
        int monthResult = month - o.getMonth();
        if (monthResult!=0){
            return monthResult;
        }
        int DaysResult = day - o.getDay();
        if (DaysResult != 0){
            return DaysResult;
        }

        return 0;
    }
}