package com.ebricks.shape.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Rectangle")
class Rectangle extends Shape{
    private int x;
    private int y;
    private int width;
    private int height;


    public Rectangle(int x, int y , int width, int height){
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void draw(){
        System.out.println("This is Rectangle class draw function");

    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public Rectangle(){
        super();
    }
}