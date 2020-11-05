package com.sheltortoiseusa.petfish;

public class Fish {
    public int x;
    public int y;

    public static final int isHungry = 1;
    public static final int isSwimming = 2;
    public static final int isEating = 3;

    private int mCondition;
    private int mVelocity;
    private int mStomachCapacity;
    private int mFoodInStomach;
    private int mTankWidth;
    private int mTankHeight;
    private int mDirection;

    private int playX, playY;
    private int foodX, foodY;

    public Fish(int xPos, int yPos, int condition, int tankWidth, int tankHeight) {
        mCondition = condition;
        mVelocity = 3;
        mStomachCapacity = 80;
        mFoodInStomach = mStomachCapacity;

        mTankWidth = tankWidth;
        mTankHeight = tankHeight;

        x = xPos;
        y = yPos;

        mDirection = 1;

        foodY = (int) tankHeight / 2 - 100;
        foodX = (int) (Math.ceil(Math.random() * mTankWidth) - mTankWidth / 2);

        playY = (int) -(Math.random() * mTankHeight / 2) + 100;
        playX = (int) (Math.ceil(Math.random() * mTankWidth)) - mTankWidth / 2;
    }
    public void move() {
        switch(mCondition) {
            case isSwimming: {
                swim();

                break;
            }
            case isHungry: {
                findFood();

                break;
            }
            case isEating: {
                eatFood();

                break;
            }
        }
    }
    private void swim() {
        mFoodInStomach --;

        int xDistance = playX - x;
        int yDistance = playY - y;

        x += xDistance / mVelocity;
        y += yDistance / mVelocity;

        if(playX < x) {
            mDirection = -1;
        }
        else {
            mDirection = 1;
        }
        if (Math.abs(xDistance) < 5 && Math.abs(yDistance) < 5) {
            playX = (int) (Math.ceil(Math.random() * mTankWidth) - mTankWidth / 2);
            playY = (int) -(Math.random() * mTankHeight / 2) + 100;
        }
        if(mFoodInStomach <= 0) {
            mCondition = isHungry;

            foodX = (int) (Math.ceil(Math.random() * mTankWidth) - mTankWidth / 2) - 100;
        }
    }
    private void findFood() {
        int xDistance = foodX - x;
        int yDistance = foodY - y;

        x += xDistance / mVelocity;
        y += yDistance / mVelocity;

        if(foodX < x) {
            mDirection = -1;
        }
        else {
            mDirection = 1;
        }
        if(Math.abs((x - foodX)) <= 10 && Math.abs(y - foodY) <= 10) {
            mCondition = isEating;
        }
    }
    private void eatFood() {
        mFoodInStomach += 4;

        if(mFoodInStomach >= mStomachCapacity) {
            mCondition = isSwimming;

            playX = (int) (Math.ceil(Math.random() * mTankWidth) - mTankWidth /2);
            playY = (int) -(Math.random() * mTankHeight / 2) + 100;
        }
    }
    public int getFacingDirection() {
        return mDirection;
    }
}