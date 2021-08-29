package com.wjkfirm.modifier.Homework13;

public class Studen extends Person {

    private int stu_id;

    public Studen(String name, char sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String study(){

        return  getName()+"承諾，我會好好學習\n";

    }

    @Override
    public String play() {

        return super.play()+"足球\n";
    }

    public void printInfo(){

        System.out.println("學生資料");
        System.out.println(super.basicInfo());
        System.out.println("學號:" + stu_id);
        System.out.println(study());
        System.out.println(play());

    }

    @Override
    public String toString() {
        return "學生資料\n" + super.toString() + "\n學號:" + stu_id +"\n" + study() + play();
    }
}

