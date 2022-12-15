package com.sheltortoiseusa.followmeandroidbuddy;

public class Friend {
    public int currentX;
    public int currentY;

    public int targetX;
    public int targetY;

    public int mVelocity;

    public Friend(int x, int y, int tx, int ty, int v) {
        currentX = x;
        currentY = y;

        targetX = tx;
        targetY = ty;

        mVelocity = v;
    }
    public void move() {
        int distX = targetX - currentX;
        currentX += distX / mVelocity;

        int distY = targetY = currentY;
        currentY += distY / mVelocity;
    }
}