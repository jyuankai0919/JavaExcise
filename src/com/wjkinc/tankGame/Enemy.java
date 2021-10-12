package com.wjkinc.tankGame;

import javax.swing.plaf.TableHeaderUI;
import java.util.Vector;

public class Enemy extends Tank implements Runnable {
    boolean isLive = true;
    Vector<Ammo> vectorAmmo = new Vector<>();
    int ammoSpeed = 20;
    Ammo ammo = null;

    public Enemy(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }


    public void enemyTankMoving(){
        //隨機設定前進步數
        int movingDistance = 15 - (int) (Math.random() * 6);//5-10
        //隨機設定前進方向
        int movingDirect = (int) (Math.random() * 4);//0-3
        setDirect(movingDirect);
        //依照方向前進
        switch (getDirect()) {
            case 0:
                for (int i = 0; i < movingDistance; i++) {
                    boolean inEdge = moveUp();
                    if (!inEdge){
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                for (int i = 0; i < movingDistance; i++) {
                    boolean inEdge = moveRight();
                    if (!inEdge){
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                for (int i = 0; i < movingDistance; i++) {
                    boolean inEdge = moveDown();
                    if (!inEdge){
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 3:
                for (int i = 0; i < movingDistance; i++) {
                    boolean inEdge = moveLeft();
                    if (!inEdge){
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public void enemyTankShot() throws InterruptedException {
        if (vectorAmmo.size() <= 2){

            switch (getDirect()) {
                case 0://上
                    //ammo.add(new Ammo(getX()+17,getY(),getDirect(),5));
                    ammo = new Ammo(getX() + 17, getY(), getDirect(), ammoSpeed);
                    break;
                case 1://右
                    //ammo.add(new Ammo(getX()+60,getY()+17,getDirect(),5));
                    ammo = new Ammo(getX() + 60, getY() + 17, getDirect(), ammoSpeed);
                    break;
                case 2://下
                    //ammo.add(new Ammo(getX()+17,getY()+60,getDirect(),5));
                    ammo = new Ammo(getX() + 17, getY() + 60, getDirect(), ammoSpeed);
                    break;
                case 3://左
                    //ammo.add(new Ammo(getX(),getY()+17,getDirect(),5));
                    ammo = new Ammo(getX(), getY() + 17, getDirect(), ammoSpeed);
                    break;

            }
            vectorAmmo.add(ammo);
            new Thread(ammo).start();
        }
    }

    @Override
    public void run() {
        while (isLive) {
            enemyTankMoving();

            try {
                enemyTankShot();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
