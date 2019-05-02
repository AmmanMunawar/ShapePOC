package com.eBricks.log4jtask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Circle extends Shape{
    private int x;
    private int y;
    private int radius;
    //creating logger objects\
    private static final Logger LOGGER = LogManager.getLogger(Shape.class.getName());
    public Circle(int x,int y ,int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void draw(){
        System.out.println("This is Circle class draw function");
        LOGGER.debug("Debug Message Logged in Circle Class!!!");

//        System.out.println("Circle Points for X = " +  this.x + "  Circle Points for Y = "
//                + this.y +"  Circle Points for Radius = " + this.radius);
    }
}