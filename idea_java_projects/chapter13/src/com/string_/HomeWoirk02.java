package com.string_;

public class HomeWoirk02 {
    public static void main(String[] args) {

    String name = "Weng Chun Kai";

    printName(name);

    }
    public static void printName(String str){

        if (str == null){
            System.out.println("輸入的文字不能為空");
            return;
        }

        String[] s = str.split(" ");
        if (s.length != 3){
            System.out.println("輸入格式錯誤");
            return;
        }

        System.out.println(String.format("%s,%s .%c",s[2],s[0],s[1].toUpperCase().charAt(0)));


    }
}


