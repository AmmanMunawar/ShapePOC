package com.ebricks.shape.executor;

import com.ebricks.shape.model.Shape;

public class ShapeFactory {

    //use getShape method to get object of type shape
    public ShapeExecutor getShapeExecuter(Shape shape) {

        if (shape == null) {
            return null;
        }

        if (shape.getClass().getSimpleName().equalsIgnoreCase("CIRCLE")) {

            return new CircleExecuter(shape);

        } else if (shape.getClass().getSimpleName().equalsIgnoreCase("RECTANGLE")) {
            return new RectangleExecuter(shape);

        }
        return null;
    }
}