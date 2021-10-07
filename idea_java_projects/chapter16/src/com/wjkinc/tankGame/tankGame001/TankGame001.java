package com.wjkinc.tankGame.tankGame001;

import javax.swing.*;

public class TankGame001 extends JFrame {

    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame001 tankGame001 = new TankGame001();
    }

    public TankGame001(){
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


}
