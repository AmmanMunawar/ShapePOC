package com.ebricks.shape.executor;

import com.ebricks.shape.model.Shape;

public class CircleExecuter extends ShapeExecutor {

    public CircleExecuter(Shape shape) {
        super(shape);
    }

    public ShapeExecuterResponse execute() {
        this.shape.draw();
        return new ShapeExecuterResponse(this.shape);
    }
}
