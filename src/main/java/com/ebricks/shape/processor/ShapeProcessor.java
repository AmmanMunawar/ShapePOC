package com.ebricks.shape.processor;

import com.ebricks.shape.executor.ShapeExecuterResponse;
import com.ebricks.shape.executor.ShapeExecutor;
import com.ebricks.shape.executor.ShapeFactory;
import com.ebricks.shape.model.Canvas;
import com.ebricks.shape.model.Circle;
import com.ebricks.shape.model.Rectangle;
import com.ebricks.shape.model.Shape;
import com.ebricks.shape.service.ShapeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ShapeProcessor {

    private static final Logger LOGGER = LogManager.getLogger(ShapeProcessor.class.getName());
    private ObjectMapper objectMapper;
    private Canvas canvas;
    private ExecutorService executor;
    private List<Future<ShapeExecuterResponse>> shapeExecutorResponseFuture;
    private ShapeService shapeService = ShapeService.getInstance();

    public void init() throws IOException {

        this.objectMapper = new ObjectMapper();
        this.canvas = objectMapper.readValue(shapeService.downloadShapes(), Canvas.class);
        this.executor = Executors.newFixedThreadPool(3);
        this.shapeExecutorResponseFuture = new ArrayList<Future<ShapeExecuterResponse>>();

    }



    public void process()  {

        try {
            shapeService.postShape(this.shapeObjectToJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (final Shape shape : this.canvas.getShapeList()) {

            Future<ShapeExecuterResponse> shapeExecuterResponseFuture =
                    this.executor.submit(new Callable<ShapeExecuterResponse>() {

                public ShapeExecuterResponse call() {
                    ShapeFactory shapeFactory = ShapeFactory.getInstance();
                    ShapeExecutor shapeExecuter = shapeFactory.getShapeExecuter(shape);
                    ShapeExecuterResponse shapeExecuterResponse = shapeExecuter.execute();
                    return shapeExecuterResponse;
                }

            }
            );
            this.shapeExecutorResponseFuture.add(shapeExecuterResponseFuture);
        }

        for(Future<ShapeExecuterResponse> shapeExecuterResponseFuture : this.shapeExecutorResponseFuture){
            try {

                shapeExecuterResponseFuture.get().logMessage();

            }
            catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Shape> createShapeList(){

        List<Shape> shapeList = new ArrayList<>();
        Circle circle = new Circle(1,2,3);
        Rectangle rectangle = new Rectangle(2,3,1,4);
        shapeList.add(circle);
        shapeList.add(rectangle);
        return shapeList;

    }

    public String shapeObjectToJsonString() throws JsonProcessingException {

        Canvas canvas = new Canvas();
        canvas.setShapeList(this.createShapeList());// this create shapelist function will return list of shape
        String shapeObjecttojsonstring = this.objectMapper.writeValueAsString(canvas);
        return shapeObjecttojsonstring;
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