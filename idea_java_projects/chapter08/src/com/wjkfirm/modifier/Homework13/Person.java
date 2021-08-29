package com.wjkfirm.modifier.Homework13;

public class Person {

    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play() {

        return name + "愛玩";

    }

    public String basicInfo() {

        return "姓名:" + name + "\n性別:" + sex + "\n年齡:" + age;

    }

    @Override
    public String toString() {

        return "姓名:" + name + "\n性別:" + sex + "\n年齡:" + age;
    }
}
