package com.ebricks.shape;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Canvas canvas = objectMapper.readValue(new File("jsonfile.json"), Canvas.class);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (final Shape shape : canvas.getShapeList()) {
                executor.execute(new Runnable() {
                public void run() {
                    shape.draw();

//                    System.out.println("Hello world");
                }
            });
        }
        executor.shutdown();
    }
}
