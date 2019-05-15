package com.ebricks.shape.executor;

import com.ebricks.shape.model.Shape;
import com.ebricks.shape.processor.ShapeProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CircleExecuter extends ShapeExecutor {

    private static final Logger LOGGER = LogManager.getLogger(ShapeProcessor.class.getName());

    public CircleExecuter(Shape shape) {
        super(shape);
    }

    public ShapeExecuterResponse execute(){
        this.shape.draw();
        return new ShapeExecuterResponse(this.shape);
    }
}
