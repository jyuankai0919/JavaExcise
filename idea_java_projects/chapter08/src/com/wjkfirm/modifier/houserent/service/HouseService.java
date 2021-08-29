package com.wjkfirm.modifier.houserent.service;

import com.wjkfirm.modifier.houserent.domain.House;

/**
 * 業務層
 * 定義house[]來保存house對象
 * 1.回應HouseView的調用
 * 2.完成對房屋訊息的各種操作 C(create) R(read) U(update) D(delete)
 */

public class HouseService {

    private House[] houses;//保存house對象
    public  HouseService(int size){

        houses = new House[size];//當宣告HouseService的時候指定數組大小

        //為了測試，先初始化一筆資料
        houses[0] = new House(0,"初始資料","113","台北市",7000,"未出租");

    }

    public House[] list(){

        return houses;

    }

}
