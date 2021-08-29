package com.wjkfirm.modifier.money_OOP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys_oop {

    //1.可以顯示菜單，並可以選擇菜單後給出相應的提示。
    //2.完成錢包明細
    //3.收益入帳
    //4.消費
    //5.退出時要詢問使用者是否真的要退出(y/n)
    //6.在收入跟消費時，判斷金額是否合理，並給出相對應的提示訊息

    //屬性
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    //2.完成錢包明細  (1)把收益及消費放進陣列中保存，但因為陣列要給空間，所以要先訂出一個上限。
    //              (2)使用對象。
    //              (3)最簡單的方法直接用字串拼接。

    String details = "==============錢包明細==============\n";


    //3.收益入帳
    //(1)定義新的變量
    double money = 0;
    double balance = 0;

    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //4.消費
    //定義新變量，輸入消費原因
    String note = "";


    public void mainMenu(){
        do {

            System.out.println("================選項================\n");
            System.out.println("\t\t\t1 錢包明細表");
            System.out.println("\t\t\t2 收益入帳");
            System.out.println("\t\t\t3 消     費");
            System.out.println("\t\t\t4 退     出");


            System.out.println("\n\n請選擇 ( 1 - 4 ) ");
            key = scanner.next();

            switch (key) {
                case "1":
                    this.detail();
                    break;

                case "2":
                    this.income();
                    break;

                case "3":
                    this.pay();
                    break;

                case "4":
                    this.exit();
                    break;

                default:
                    System.out.println("選擇錯誤，請重新選擇");
            }

        }while (loop);

        System.out.println("-------------------退出了錢包-------------------");


    }
    public void detail() {

        System.out.println(details);

    }
    public void income(){

        System.out.println("收益入帳金額");
        money = scanner.nextDouble();
        //數值需要檢驗，晚點再寫出條件。
        //找出不正確的條件後給出提示，直接break

        if (money <= 0 ){
            System.out.println("收益金額必須大於 0 ");
            return;
        }

        balance += money;

        //將收入放進明細中details
        date = new Date();//獲得當前時間
        details += "\n收益入帳\t+" + money + "\t\t" + sdf.format(date) + "\t餘額:" +balance;


    }
    public void pay(){

        System.out.println("消費金額");
        money = scanner.nextDouble();
        //金額不正確的情況
        if (money <= 0 || money > balance){
            System.out.println("消費金額必須在0元~"+balance+"元");
            return;
        }

        //輸入消費原因
        System.out.println("消費說明");
        note = scanner.next();

        balance -= money;

        //將消費資料加入明細中
        date = new Date();//獲得當前時間
        details += "\n" + note +"\t\t-" + money + "\t\t" + sdf.format(date) + "\t餘額:" + balance;

    }
    public void exit(){

        //退出時要詢問使用者是否真的要退出(y/n)，必須輸入正確的(y/n)
        //否則循環輸入指令，直到輸入(y/n)

        //(1)先定義一個變量，接收使用這輸入的決定 choice
        //(2)使用while + break ，來處理接收到的回答。
        //(3)退出while後再判斷是(y/n)
        String choice = "";
        while (true){//確定用戶輸入的是(y/n)，否則無限輪迴
            System.out.println("你確定要退出嗎?  (y/n)");
            choice = scanner.next();
            if ("y".equals(choice)||"n".equals(choice)){
                break;
            }
        }
        if ("y".equals(choice)){
            loop = false;
        }

    }




}
