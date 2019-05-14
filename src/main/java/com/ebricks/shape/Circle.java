package com.ebricks.shape;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@JsonTypeName("Circle")
class Circle extends Shape{
    private int x;
    private int y;
    private int radius;
    private static final Logger LOGGER = LogManager.getLogger(Circle.class.getName());

    //creating logger objects\
    public Circle(){
            super();
    }
    public Circle(int x,int y ,int radius){
        super();
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void draw(){
        System.out.println("This is Circle class draw function");
//        LOGGER.fatal("Debug Message Logged in Circle Class!!!");
//        LOGGER.fatal("Fatal Message Logged in Circle Class!!!");

//        System.out.println("Circle Points for X = " +  this.x + "  Circle Points for Y = "
//                + this.y +"  Circle Points for Radius = " + this.radius);
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

}