package com.ebricks.shape.executor;

import com.ebricks.shape.model.Shape;
import com.ebricks.shape.processor.ShapeProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeExecutor {

    private static final Logger LOGGER = LogManager.getLogger(ShapeProcessor.class.getName());
    protected Shape shape;

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void execute(){
         this.shape.draw();
     }
}
