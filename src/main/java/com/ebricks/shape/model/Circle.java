package com.ebricks.shape.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Circle extends Shape{

    private static final Logger LOGGER = LogManager.getLogger(Circle.class.getName());
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    public void draw(){
        LOGGER.info("This is Circle class draw function");
    }

}