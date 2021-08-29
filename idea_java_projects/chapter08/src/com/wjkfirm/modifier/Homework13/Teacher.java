package com.wjkfirm.modifier.Homework13;

public class Teacher extends Person {
    private int work_age;


    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public String teach() {

        return getName() + "承諾，我會認真教學\n";

    }

    @Override
    public String play() {

        return super.play() + "象棋\n";
    }

    public void printInfo() {

        System.out.println("老師資料");
        System.out.println(super.basicInfo());
        System.out.println("年資:" + work_age);
        System.out.println(teach());
        System.out.println(play());

    }

    @Override
    public String toString() {
        return "老師資料\n" + super.toString() + "\n年資:" + work_age + "\n" + teach() + play();
    }
}

