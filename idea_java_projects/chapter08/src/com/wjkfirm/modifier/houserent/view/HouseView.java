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
    private char key = ' ';
    private HouseService houseService = new HouseService(10);//宣告一個houses並創建10欄位位置

    //1.接收新增的房屋資料，接收用戶輸入的方屋資料，調用service的add方法
    public void addHouse() {

        System.out.println("==================新增房屋==================");
        System.out.println("姓名: ");
        String name = scanner.next();
        System.out.println("電話: ");
        String phone = scanner.next();
        System.out.println("地址: ");
        String address = scanner.next();
        System.out.println("月租: ");
        int rent = scanner.nextInt();
        System.out.println("狀態: ");
        String state = scanner.next();


        //新增一個House對象，ID是系統給的，無法自訂。
        House newHouse = new House(0, name, "\t" + phone, address + "\t", rent, state);


        //已將newHouse傳入HouseService中後加入houses數組中，等service判斷是否成功回傳T/F
        if (houseService.add(newHouse)) {

            System.out.println("==================新增成功==================\n");

        } else {

            System.out.println("==================新增失敗==================\n");

        }


    }

    //2.刪除房屋資料，接收要刪除ID號碼，調用service的del方法
    public void delHouse() {

        System.out.println("==================刪除房屋==================");
        System.out.println("請輸入要刪除的房屋編號(-1退出):");
        int delID = scanner.nextInt();
        char check = ' ';
        if (delID == -1) {
            System.out.println("=================取消刪除房屋=================");
            return;
        }
        System.out.println("請確認是否要刪除編號 " + delID + " (y/n):");
        check = scanner.next().charAt(0);
        if (check == 'y') {
            if (houseService.del(delID)) {
                System.out.println("=================成功刪除房屋=================");
            } else {
                System.out.println("================無效的房屋編號================");
            }
        } else {
            System.out.println("=================取消刪除房屋=================");
        }

    }


    //5.顯示房屋列表
    public void listHouses() {
        System.out.println("==================房屋列表==================\n");
        System.out.println("編號\t\t房主\t\t電話\t\t地址\t\t月租\t\t狀態(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }

            System.out.println(houses[i]);

        }

    }


    //main.顯示主菜單

    public void mainMenu() {

        do {

            System.out.println("==================房屋出租系統菜單==================");
            System.out.println("\t\t\t\t  1 新 增 房 源");
            System.out.println("\t\t\t\t  2 搜 尋 房 屋");
            System.out.println("\t\t\t\t  3 刪 除 房 屋 訊 息");
            System.out.println("\t\t\t\t  4 修 改 房 屋 訊 息");
            System.out.println("\t\t\t\t  5 房 屋 列 表");
            System.out.println("\t\t\t\t  6 退      出");
            System.out.println("請輸入你的選擇(1 - 6):");
            key = scanner.next().charAt(0);

            switch (key) {

                case '1':
                    addHouse();
                    break;

                case '2':
                    System.out.println("2 搜 尋 房 屋");
                    break;

                case '3':
                    delHouse();
                    break;

                case '4':
                    System.out.println("4 修 改 房 屋 訊 息");
                    break;

                case '5':
                    listHouses();
                    break;

                case '6':
                    System.out.println("6 退      出");
                    loop = false;
                    break;


            }


        } while (loop);


    }


}
