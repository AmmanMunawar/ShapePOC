package com.eBricks.log4jtask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Circle circle_object = new Circle(1,2,3);
        Rectangle rectangle_object = new Rectangle(2,1,3,2);

        Shape shape_object = circle_object;
        shape_object.draw();
        shape_object = rectangle_object;
        shape_object.draw();

        //these are main class logger
        System.out.println("Hello world!!");
        LOGGER.debug("Debug Message Logged in Main Class!!!");
//        LOGGER.info("Info Message Logged !!!");
//        LOGGER.fatal("This is an Fatal message");
        //LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
//        System.out.println("Completed!!");


    }
//    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
//
//    public static void main(String[] args)
//    {
//        System.out.println("Hello world!!");
//        LOGGER.debug("Debug Message Logged !!!");
//        LOGGER.info("Info Message Logged !!!");
//        LOGGER.fatal("This is an Fatal message");
//        //LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
//        System.out.println("Completed!!");
//    }
}
