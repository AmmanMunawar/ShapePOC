package com.ebricks.shape;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
//        String string = "{/"x"/:1,/"y"/:2,/"radius"/:3}";
            String jsonforcircle = "{ \"x\" : 12, \"y\" : 32,\"radius\" : 34 }";
            Shape shape = objectMapper.readValue(jsonforcircle, Circle.class); //circle
            shape.draw();
            String jsonforrectangle = "{ \"x\" : 12, \"y\" : 32,\"width\" : 34,\"height\":23 }";
            shape = objectMapper.readValue(jsonforrectangle, Rectangle.class);
            shape.draw();


            //these are main class logger
            System.out.println("Hello world!!");
            LOGGER.debug("Logged in Main Class Debug !!!");
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }

    }

}
