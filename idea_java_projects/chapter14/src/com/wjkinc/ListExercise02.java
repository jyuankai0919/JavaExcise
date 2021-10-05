package com.wjkinc;

import java.awt.print.Book;
import java.util.*;

public class ListExercise02 {

    public static void main(String[] args) {

        List list = new LinkedList();

        list.add(new book("紅樓夢", 550, "曹雪芹"));
        list.add(new book("西遊記", 450, "吳承恩"));
        list.add(new book("水滸傳", 1050, "施耐庵"));
        list.add(new book("三國演義", 950, "羅貫中"));

        for (Object o : list) {
            System.out.println(o);
        }

        sort(list);

        System.out.println("--------排序後--------");
        for (Object o : list) {
            System.out.println(o);
        }

    }

    public static void sort(List list) {


        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                //取出book物件
                book book1 = (book) list.get(j);
                book book2 = (book) list.get(j + 1);

                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }
}




class book {

    private String name;
    private double price;
    private String writer;

    public book(String name, double price, String writer) {
        this.name = name;
        this.price = price;
        this.writer = writer;
    }

    @Override
    public String toString() {
        return String.format("名稱:%s\t\t價格:%.1f\t\t作者:%s", name, price, writer);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

}