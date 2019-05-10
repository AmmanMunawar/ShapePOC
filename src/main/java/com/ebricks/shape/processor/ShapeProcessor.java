package com.ebricks.shape.processor;

import com.ebricks.shape.model.Canvas;
import com.ebricks.shape.model.Shape;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ShapeProcessor {

    private static final Logger LOGGER = LogManager.getLogger(ShapeProcessor.class.getName());
    private ObjectMapper objectMapper;
    private Canvas canvas;
    private ExecutorService executor;
    private List<Future<Shape>> shapesFuture;

    public void init() throws IOException {

        this.objectMapper = new ObjectMapper();
        this.canvas = objectMapper.readValue(new File("C:\\Users\\Aman Munawar\\IdeaProjects\\log4j2practise\\src\\main\\resources\\json.json"), Canvas.class);
        this.executor = Executors.newFixedThreadPool(1);
        this.shapesFuture = new ArrayList<Future<Shape>>();

    }

    public void process(){

        for (final Shape shape : this.canvas.getShapeList()) {
            Future<Shape> shapeFuture = this.executor.submit(new Callable<Shape>() {
                public Shape call() {
                    shape.draw();
                    return shape;
                }
            }
            );
            this.shapesFuture.add(shapeFuture);
        }

        for(Future<Shape> future : this.shapesFuture){
            try {

                System.out.println(new Date()+ "::"+future.get());
            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public void end(){

        if (this.executor!=null) {

            this.executor.shutdown();
            try {
                if(!this.executor.awaitTermination(10,TimeUnit.SECONDS)){
                    LOGGER.info("Task didn't complete in given time");
                }
            } catch (InterruptedException e) {
                LOGGER.error(e);
            }
        }

    }
}