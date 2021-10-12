package com.wjkinc.tankGame;

public class Tank {
    /**
     * 坦克座標(x,y)
     */

    private int x;
    private int y;
    private int direct;//0:上 1:右 2:下 3:左
    private int speed;

    public boolean moveUp() {
        if (getY() > 0) {
            y -= speed;
            return true;
        } else {
            y += speed;
            return false;
        }

    }

    public boolean moveDown() {
        if (getY() + 80 < 800) {
            y += speed;
            return true;
        }else{
            y -= speed;
            return false;
        }

    }

    public boolean moveRight() {
        if (getX() + 60 < 1440) {
            x += speed;
            return true;
        }else{
            x -= speed;
            return false;
        }
    }

    public boolean moveLeft() {
        if (getX() > 0) {
            x -= speed;
            return true;
        }else{
            x += speed;
            return false;
        }
    }

    public Tank(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int setX(int x) {
        this.x = x;
        return x;
    }

    public int getY() {
        return y;
    }

    public int setY(int y) {
        this.y = y;
        return y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
