package com.wjkfirm.modifier.houserent;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wjkfirm.modifier.houserent.view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {

        HouseView houseView = new HouseView();
        houseView.mainMenu();
        System.out.println("===============你退出了出租系統================");

    }
}
