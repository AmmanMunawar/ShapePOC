package com.ebricks.shape.processor;

import com.ebricks.shape.models.Canvas;
import com.ebricks.shape.models.Shape;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ShapeProcessor {

    public ObjectMapper objectMapper;
    public Canvas canvas;
    public ExecutorService executor;
    public List<Future> futures;

    public void init() throws IOException {

        this.objectMapper = new ObjectMapper();
        this.canvas = objectMapper.readValue(new File("jsonfile.json"), Canvas.class);
        this.executor = Executors.newFixedThreadPool(1);
        this.futures = new ArrayList<Future>();

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
            this.futures.add(shapeFuture);
        }

        for(Future<Shape> future : this.futures){
            try {

                System.out.println(new Date()+ "::"+future.get());
            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
    public void end(){
        this.executor.shutdown();
    }
}
