package com.wjkfirm.modifier.houserent.service;

import com.wjkfirm.modifier.houserent.domain.House;

/**
 * 業務層
 * 定義house[]來保存house對象
 * 1.回應HouseView的調用
 * 2.完成對房屋訊息的各種操作 C(create) R(read) U(update) D(delete)
 */

public class HouseService {

    private House[] houses;//保存house資料
    private int houseNum = 1;//計算目前幾筆資料
    private int houseID = 1;//將對應ID編進houseID中

    public HouseService(int size) {
        houses = new House[size];//當宣告HouseService的時候指定數組大小
        //為了測試，先初始化一筆資料
        houses[0] = new House(0, "初始資料", "113", "台北市", 7000, "未出租");
    }

    //1. add方法，新增新的資料到house數組中，返回boolean
    public boolean add(House newHouse) {
        if (houseNum == houses.length) {//數組已滿，不能再新增了
            System.out.println("數量已滿，無法再新增新的房屋...");
            return false;
        }
        //把目前ID新增進入newHouse裡面
        newHouse.setId(houseID);
        houseID++;

        //把新的newHouse加入到houses中
        houses[houseNum] = newHouse;
        houseNum++;
        return true;
    }
    //2. find方法，尋找房屋ID並顯示該房屋資料
    public House find(int findID){
        //如果找到ID號碼，則直接回傳houses[i]
        for (int i = 0; i < houseNum; i++) {
            if (findID == houses[i].getId()){
             return houses[i];
            }
        }
        //如果沒有找到直接回傳空值給View做判斷
        return null;
    }
    //3. del方法，刪除一個房屋資料
    public boolean del(int delId) {
        int index = -1;
        //尋找目前所有的houses數量
        for (int i = 0; i < houseNum; i++) {
            if (houses[i].getId() == delId) {//如果要刪除的ID等於houses的ID，用index紀錄houses的下標[i]
                index = i;
            }
        }
        //如果沒找到退出迴圈
        if (index == -1) {
            return false;
        }
        //確定要刪除的houses[i]後，將要刪除的資料用後一筆資料取代，並將最後一組資料設為空值null
        for (int i = index; i < houseNum; i++) {
            houses[i] = houses[i+1];
        }
        houses[houseNum] = null;
        houseNum--;

        return true;
    }
    //4. 修改房屋訊息
    public House update(int updateId){
        //尋找目前所有的houses數量
        for (int i = 0; i < houseNum; i++) {
            if (houses[i].getId() == updateId) {
                return houses[i];
            }
        }
        return null;
    }
    //使用此方法回傳houses裡儲存的資料
    public House[] list() {
        return houses;
    }
}
