package com.wjkinc.tankGame;

import javax.swing.*;

public class TankGame002 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {
        TankGame002 tankGame002 = new TankGame002();
    }

    public TankGame002() {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1440, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


}
