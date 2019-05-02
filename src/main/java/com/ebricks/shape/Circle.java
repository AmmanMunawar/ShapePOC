package com.ebricks.shape;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Circle extends Shape{
    private int x;
    private int y;
    private int radius;
    private static final Logger LOGGER = LogManager.getLogger(Circle.class.getName());

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

    //creating logger objects\
    public Circle(){

    }
    public Circle(int x,int y ,int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void draw(){
        System.out.println("This is Circle class draw function");
        LOGGER.fatal("Debug Message Logged in Circle Class!!!");
        LOGGER.fatal("Fatal Message Logged in Circle Class!!!");

//        System.out.println("Circle Points for X = " +  this.x + "  Circle Points for Y = "
//                + this.y +"  Circle Points for Radius = " + this.radius);
    }
}