package com.ebricks.shape.executor;

import com.ebricks.shape.model.Shape;
import com.ebricks.shape.processor.ShapeProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeExecutor {

    private static final Logger LOGGER = LogManager.getLogger(ShapeProcessor.class.getName());
    public Shape shapeobject;

    public void execute(){
         this.shapeobject.draw();
     }
}
