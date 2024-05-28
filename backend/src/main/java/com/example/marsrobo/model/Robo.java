package com.example.marsrobo.model;

public class Robo {
    private int x;
    private int y;
    private char direction;

    public Robo() {
        this.x = 0;
        this.y = 0;
        this.direction = 'N';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
}
