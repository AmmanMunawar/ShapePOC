package com.ebricks.shape;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {
//        Circle circle_object = new Circle(1,2,3);
        Shape shape = new Circle(1,2,3);
        shape.draw();
        shape = new Rectangle(2,1,3,2);
        shape.draw();


        //these are main class logger
        System.out.println("Hello world!!");
        LOGGER.debug("Logged in Main Class Debug !!!");


    }

}
