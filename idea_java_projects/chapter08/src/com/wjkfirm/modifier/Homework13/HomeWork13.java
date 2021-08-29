package com.wjkfirm.modifier.Homework13;

public class HomeWork13 {

    public static void main(String[] args) {

        Person[] people = new Person[4];

        people[0] = new Studen("1", '男', 20, 10101);
        people[1] = new Studen("2", '女', 18, 10102);
        people[2] = new Teacher("3", '男', 40, 15);
        people[3] = new Teacher("4", '女', 35, 10);

        HomeWork13 homeWork13 = new HomeWork13();
        homeWork13.rank(people);

        System.out.println("-----------排序後的資料-----------");

        for (int i = 0; i < people.length; i++) {

            System.out.println(people[i]);

        }

        System.out.println("-----------排序後的資料調用各自的方法-----------");


        for (int i = 0; i < people.length; i++) {

            homeWork13.test(people[i]);

        }


    }


    public void test(Person p) {

        if (p instanceof Studen) {

            ((Studen) p).study();

        } else if (p instanceof Teacher) {

            ((Teacher) p).teach();

        } else {

            System.out.println("Error");

        }


    }


    public void rank(Person[] people) {
        Person temp = null;
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {

                if (people[j].getAge() < people[j + 1].getAge()) {
                    temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;


                }
            }
        }
    }
}


