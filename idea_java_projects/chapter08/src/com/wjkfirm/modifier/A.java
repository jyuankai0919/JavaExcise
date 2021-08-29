package com.wjkfirm.modifier;

public class A {
    public static void main(String[] args) {

        Person person = new Person();
        person.setName("hey");
        person.setAge(120);
        person.setSalaryl(30000);
        System.out.printf(person.info());

    }
}

class Person {

    public String name;//名字公開

    private int age; //私有資料

    private double salary;


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

        if (age >= 1&& age<=120){
            this.age = age;
        }else{
            System.out.println("年齡需要再1-120");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalaryl(double salary) {
        this.salary = salary;
    }

    //寫一個返回屬性訊息的方法
    public String info() {

        return "訊息為 name=" + name + "age=" + age + "薪水=" + salary;
    }

}


