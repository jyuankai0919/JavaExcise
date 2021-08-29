package com.wjkfirm.modifier.houserent.view;

import com.wjkfirm.modifier.houserent.domain.House;
import com.wjkfirm.modifier.houserent.service.HouseService;

import java.util.Scanner;

/**
 * 1.顯示介面
 * 2.接收用戶的輸入
 * 3.調用HouseService完成對房屋訊息的各種操作
 */

public class HouseView {

    Scanner scanner = new Scanner(System.in);

    private boolean loop = true;
    private char key=' ';
    private HouseService houseService = new HouseService(10);

    //顯示房屋列表
    public void listHouses(){
        System.out.println("==================房屋列表==================");
        System.out.println("編號\t\t房主\t\t電話\t\t地址\t\t月租\t\t狀態(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null ){
                break;
            }

            System.out.println(houses[i]);

        }

    }



    //顯示主菜單

    public void mainMenu(){

        do{

            System.out.println("==================房屋出租系統菜單==================");
            System.out.println("\t\t\t\t  1 新 增 房 源");
            System.out.println("\t\t\t\t  2 搜 尋 房 屋");
            System.out.println("\t\t\t\t  3 刪 除 房 屋 訊 息");
            System.out.println("\t\t\t\t  4 修 改 房 屋 訊 息");
            System.out.println("\t\t\t\t  5 房 屋 列 表");
            System.out.println("\t\t\t\t  6 退      出");
            System.out.println("請輸入你的選擇(1 - 6):");
            key = scanner.next().charAt(0);

            switch (key){

                case '1':
                    System.out.println("1 新 增 房 源");
                    break;

                case '2':
                    System.out.println("2 搜 尋 房 屋");
                    break;

                case '3':
                    System.out.println("3 刪 除 房 屋 訊 息");
                    break;

                case '4':
                    System.out.println("4 修 改 房 屋 訊 息");
                    break;

                case '5':
                    System.out.println("5 房 屋 列 表");
                    listHouses();
                    break;

                case '6':
                    System.out.println("6 退      出");
                    loop = false;
                    break;



            }


        }while (loop);



    }


}
