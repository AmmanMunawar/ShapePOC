package com.ebricks.shape.processor;

import com.ebricks.shape.model.Canvas;
import com.ebricks.shape.model.Shape;
import com.ebricks.shape.service.ServletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ShapeProcessor {

    private static final Logger LOGGER = LogManager.getLogger(ShapeProcessor.class.getName());
    private ObjectMapper objectMapper;
    private Canvas canvas;
    private Shape shape;
    private ExecutorService executor;
    private List<Future<Shape>> shapesFuture;
    private static ServletService servletService = new ServletService();

    public void init() throws IOException {

        this.objectMapper = new ObjectMapper();
        this.canvas = objectMapper.readValue(servletService.downloadShapes(), Canvas.class);
        this.executor = Executors.newFixedThreadPool(1);
        this.shapesFuture = new ArrayList<Future<Shape>>();
    }

    public String objectToJsonString() throws JsonProcessingException {

        canvas = null;
        canvas = new Canvas();
        shape = null;
        shape = new Shape();
        canvas.setShapeList(shape.createShapeList());// this create shapelist function will return list of shape
        String objecttojsonstring = this.objectMapper.writeValueAsString(canvas);
        return objecttojsonstring;

    }

    public void process() throws IOException {

        servletService.postShape(this.objectToJsonString());

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

                LOGGER.info(new Date()+ "::"+future.get());
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