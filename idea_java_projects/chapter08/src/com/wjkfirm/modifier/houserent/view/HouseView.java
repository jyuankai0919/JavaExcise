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
        System.out.println("==================新增房屋==================\n");
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
        House newHouse = new House(0, name, phone, address, rent, state);

        //已將newHouse傳入HouseService中後加入houses數組中，等service判斷是否成功回傳T/F
        if (houseService.add(newHouse)) {
            System.out.println("==================新增成功==================\n");
        } else {
            System.out.println("==================新增失敗==================\n");
        }
    }
    //2.房屋搜尋功能
    public void findHouse() {
        //請使用主輸入要選擇的房屋編號，輸入-1則退出。
        System.out.println("==================搜尋房屋==================\n");
        System.out.println("請輸入要搜尋的房屋編號(-1 退出):");
        int findID = scanner.nextInt();
        char check = ' ';
        if (findID == -1) {
            System.out.println("==================取消搜尋==================\n");
            return;
        }
        //將搜尋編號ID傳入find方法中搜尋，如果找到則回傳資料houses[i]，沒找到回傳空值
        House returnValue = houseService.find(findID);
        if (returnValue == null) {
            System.out.println("================無效的房屋編號================\n");
        } else {//將找到的結果顯示出來
            System.out.println("================以下是搜尋結果================\n");
            System.out.println("編號\t\t房主\t\t電話\t\t地址\t\t月租\t\t狀態(未出租/已出租)");
            System.out.println(returnValue);
        }
    }
    //3.刪除房屋資料，接收要刪除ID號碼，調用service的del方法
    public void delHouse() {

        System.out.println("==================刪除房屋==================\n");
        System.out.println("請輸入要刪除的房屋編號(-1 退出):");
        int delID = scanner.nextInt();
        char check = ' ';
        if (delID == -1) {
            System.out.println("=================取消刪除房屋=================\n");
            return;
        }
        System.out.println("請確認是否要刪除編號 " + delID + " (y/n):");
        check = scanner.next().charAt(0);
        if (check == 'y') {
            if (houseService.del(delID)) {
                System.out.println("=================成功刪除房屋=================\n");
            } else {
                System.out.println("================無效的房屋編號================\n");
                return;
            }
        } else {
            System.out.println("=================取消刪除房屋=================\n");
            return;
        }
    }
    //4.修改房屋訊息
    public void update() {
        System.out.println("=================修改房屋列表=================\n");
        System.out.println("請選擇要修改的房屋編號(-1退出)");
        int updateId = scanner.nextInt();
        if (updateId == -1) {
            System.out.println("==================取消修改==================\n");
            return;
        }
        House house = houseService.update(updateId);

        if (house != null) {//回傳的資料如果是null則表示輸入的資料錯誤
            System.out.println("請輸入要修改的資料");
            System.out.print("姓名:(" + house.getName() + ")");
            String name = scanner.next();
            house.setName(name);

            System.out.print("電話:(" + house.getPhone() + ")");
            String phone = scanner.next();
            house.setPhone(phone);

            System.out.print("地址:(" + house.getAddress() + ")");
            String address = scanner.next();
            house.setAddress(address);

            System.out.print("月租:(" + house.getRent() + ")");
            int rant = scanner.nextInt();
            house.setRent(rant);

            System.out.print("狀態:(" + house.getState() + ")");
            String state = scanner.next();
            house.setState(state);
            System.out.println("================成功修改房屋列表================\n");

        } else {
            System.out.println("================無效的房屋編號================\n");
            return;
        }
    }
    //5.顯示房屋列表
    public void listHouses() {
        System.out.println("==================房屋列表==================");
        System.out.println("編號\t\t房主\t\t電話\t\t地址\t\t月租\t\t狀態(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
    }
    //6.退出程式
    public void Exit() {
        System.out.println("請確認是否要退出程式(y/n):");
        char c = scanner.next().charAt(0);
        if (c == 'y') {
            loop = false;
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
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    Exit();
                    break;
            }
        } while (loop);
    }
}
