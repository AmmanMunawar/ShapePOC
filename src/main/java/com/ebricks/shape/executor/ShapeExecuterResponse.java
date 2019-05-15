package com.ebricks.shape.executor;

import com.ebricks.shape.model.Shape;
import com.ebricks.shape.processor.ShapeProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeExecuterResponse {

    private static final Logger LOGGER = LogManager.getLogger(ShapeProcessor.class.getName());
    private String shapeSubClassType;
    protected Shape shape;

    public ShapeExecuterResponse(Shape shape) {
        this.shape = shape;
        this.shapeSubClassType = this.shape.getType();
    }

    public void logMessage() {

        LOGGER.info("This is the Response of " + this.shapeSubClassType);

    }

}
