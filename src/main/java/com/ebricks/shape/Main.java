package com.ebricks.shape;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        LOGGER.debug("Debug Message Logged in Circle Class!!!");
        ObjectMapper objectMapper = new ObjectMapper();
        Canvas canvas = objectMapper.readValue(new File("jsonfile.json"), Canvas.class);
        ExecutorService executor = Executors.newFixedThreadPool(1);
        List<Future> futures = new ArrayList<Future>();
        for (final Shape shape : canvas.getShapeList()) {
                Future<Shape> shapeFuture = executor.submit(new Callable<Shape>() {
                    public Shape call() {
                        shape.draw();
                        return shape;
                    }
            }
            );
                futures.add(shapeFuture);
        }
        for(Future<Shape> future : futures){
            try {

                System.out.println(new Date()+ "::"+future.get());
            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
