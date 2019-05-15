package com.ebricks.shape.processor;

import com.ebricks.shape.executor.ShapeExecuterResponse;
import com.ebricks.shape.executor.ShapeExecutor;
import com.ebricks.shape.executor.ShapeFactory;
import com.ebricks.shape.model.Canvas;
import com.ebricks.shape.model.Shape;
import com.ebricks.shape.service.ShapeService;
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
    private List<Future<ShapeExecuterResponse>> shapeExecutorResponseFuture;
    private static ShapeService shapeService = new ShapeService();

    public void init() throws IOException {

        this.objectMapper = new ObjectMapper();
        this.canvas = objectMapper.readValue(shapeService.downloadShapes(), Canvas.class);
        this.executor = Executors.newFixedThreadPool(3);
        this.shapeExecutorResponseFuture = new ArrayList<Future<ShapeExecuterResponse>>();

    }

    public String shapeObjectToJsonString() throws JsonProcessingException {

        canvas = null;
        canvas = new Canvas();
        shape = null;
        shape = new Shape();
        canvas.setShapeList(shape.createShapeList());// this create shapelist function will return list of shape
        String objecttojsonstring = this.objectMapper.writeValueAsString(canvas);
        return objecttojsonstring;

    }

    public void process()  {

        try {
            shapeService.postShape(this.shapeObjectToJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (final Shape shape : this.canvas.getShapeList()) {
            Future<ShapeExecuterResponse> shapeExecuterResponseFuture = this.executor.submit(new Callable<ShapeExecuterResponse>() {
                public ShapeExecuterResponse call() {
                    ShapeExecutor shapeExecuter = new ShapeFactory().getShapeExecuter(shape);
                    ShapeExecuterResponse shapeExecuterResponse = shapeExecuter.execute();
//                    shape.draw();
                    System.out.println(shape.getType());
//                    LOGGER.info(shape.getClass().getSimpleName());
                    return shapeExecuterResponse;
                }
            }
            );
            this.shapeExecutorResponseFuture.add(shapeExecuterResponseFuture);
        }

        for(Future<ShapeExecuterResponse> shapeExecuterResponseFuture : this.shapeExecutorResponseFuture){
            try {

                shapeExecuterResponseFuture.get().getShapeExecuterResponse();

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