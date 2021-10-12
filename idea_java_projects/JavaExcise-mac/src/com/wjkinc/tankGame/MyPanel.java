package com.wjkinc.tankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定義我的坦克
    Hero hero = null;
    //定義敵人坦克
    Vector<Enemy> enemyTank = new Vector<>();
    int enemySize = 6;
    //定義爆炸效果
    Vector<Bomb> bombs = new Vector<>();
    Image image01 = null;
    Image image02 = null;
    Image image03 = null;


    public MyPanel() {
        //初始化自己坦克
        hero = new Hero(600, 600, 0, 30);

        //初始化敵人坦克
        for (int i = 0; i < enemySize; i++) {
            Enemy enemy = new Enemy(200 * (i + 1), 100, 2, 5);
            //給Enemy加入一顆子彈
            Ammo ammo = new Ammo(enemy.getX() + 20, enemy.getY() + 60, enemy.getDirect(), 20);
            //把ammo加入enemy的Vector成員
            enemy.vectorAmmo.add(ammo);
            //啟動坦克
            new Thread(enemy).start();
            //啟動 ammo
            new Thread(ammo).start();
            //加入
            enemyTank.add(enemy);
        }

        //初始化圖片
        image01 = Toolkit.getDefaultToolkit().getImage("out/production/chapter18/bomb_1.gif");
        image02 = Toolkit.getDefaultToolkit().getImage("out/production/chapter18/bomb_2.gif");
        image03 = Toolkit.getDefaultToolkit().getImage("out/production/chapter18/bomb_3.gif");

    }

    /**
     * 依照下方run function設定
     * 此function每50ms更新一次
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1440, 800);//填充矩形，默认黑色

//        //畫出我方子彈
//        if (hero.ammo != null && hero.ammo.isLive) {
//            g.setColor(Color.yellow);//將我方子彈設定成黃色
//            //g.fill3DRect(hero.ammo.get(hero.i).x,hero.ammo.get(hero.i).y,5,5,false);
//            g.fill3DRect(hero.ammo.x, hero.ammo.y, 5, 5, false);
//        }
        for (int i = 0; i < hero.vectorAmmo.size(); i++) {
            Ammo ammo = hero.vectorAmmo.get(i);
            if (ammo != null && ammo.isLive) {
                g.setColor(Color.yellow);//將我方子彈設定成黃色
                g.fill3DRect(ammo.x, ammo.y, 5, 5, false);
            } else {
                hero.vectorAmmo.remove(ammo);
            }
        }


        //畫出坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        //畫出敵人坦克
        for (int i = 0; i < enemyTank.size(); i++) {
            //取出坦克
            Enemy enemy = enemyTank.get(i);
            //判斷坦克是否存活
            if (enemy.isLive) {
                //畫出坦克
                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 0);
                //畫出所有vectorAmmo中的子彈
                for (int j = 0; j < enemy.vectorAmmo.size(); j++) {
                    //取出子彈
                    Ammo ammo = enemy.vectorAmmo.get(j);
                    //繪製，須先判斷子彈是否存活，如果死亡則將子彈移除
                    if (ammo.isLive) {
                        g.fill3DRect(ammo.x, ammo.y, 5, 5, false);
                    } else {
                        //從vector中移除
                        enemy.vectorAmmo.remove(j);
                    }
                }
            }
        }

        //畫出炸彈
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);

            if (bomb.isLive) {
                if (bomb.life > 12) {
                    int aborted = MediaTracker.ABORTED;
                    g.drawImage(image01, bomb.x, bomb.y, 60, 60, this);
                } else if (bomb.life > 6) {
                    g.drawImage(image02, bomb.x, bomb.y, 60, 60, this);
                } else {
                    g.drawImage(image03, bomb.x, bomb.y, 60, 60, this);
                }
                //每畫出一次炸彈生命減一
                bomb.lifeDown();
                //判斷炸彈是否還存活，如果為零，就將此炸彈移除
                if (bomb.life <= 0) {
                    bombs.remove(i);
                }
            }
        }
    }

    /**
     * 編寫出一個方法，判斷我方子彈是否擊中敵方坦克
     *
     * @param a     我方子彈
     * @param enemy 敵人坦克
     * @return 是否有擊中坦克
     */
    public boolean hit(Ammo a, Enemy enemy) {
        //判斷子彈a是否進入坦克中
        switch (enemy.getDirect()) {
            //坦克面向上下
            case 0:
            case 2:
                if (a.x > enemy.getX() && a.x < enemy.getX() + 40 //判斷x座標
                        && a.y > enemy.getY() && a.y < enemy.getY() + 60) {//判斷y座標
                    a.isLive = false;
                    enemy.isLive = false;
                    //當子彈擊中敵人，在敵人的座標位置加入一個bomb到vector當中
                    Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                    bombs.add(bomb);
                    return true;
                }
                break;

            //坦克面向左右
            case 1:
            case 3:
                if (a.x > enemy.getX() && a.x < enemy.getX() + 60 //判斷x座標
                        && a.y > enemy.getY() && a.y < enemy.getY() + 40) {//判斷y座標
                    a.isLive = false;
                    enemy.isLive = false;
                    Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                    bombs.add(bomb);
                    return true;
                }
                break;
        }
        return false;
    }

    //判斷完是否擊中坦克後，調用此方法確定每顆子彈是否擊中任意坦克
    public void hitEnemyTank() {
        for (int i = 0; i < hero.vectorAmmo.size(); i++) {
            Ammo ammo = hero.vectorAmmo.get(i);
            if (ammo != null && ammo.isLive) {
                for (int j = 0; j < enemyTank.size(); j++) {
                    Enemy enemy = enemyTank.get(j);
                    //如果子彈擊中坦克，將坦克從vector中移除
                    if (hit(ammo, enemy)) {
                        enemyTank.remove(j);
                    }
                }
            }
        }
    }


    /**
     * 编写方法，画出坦克
     *
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制坦克
        //0:表示向上 1:表示向右 2:表示向下 3:表示向左
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    //當某鍵按下後，該方法觸發
    //0:表示向上 1:表示向右 2:表示向下 3:表示向左
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirect(3);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirect(1);
            hero.moveRight();
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE && hero.vectorAmmo.size() <= 5) {
            hero.shotEnemyTank();

        }
        this.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判斷子彈是否擊中了坦克
            hitEnemyTank();

            this.repaint();
        }
    }


}


