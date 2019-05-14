package com.ebricks.shape.executor;

import com.ebricks.shape.model.Shape;

public class ShapeFactory {

    //use getShape method to get object of type shape
    public ShapeExecutor getShapeExecuter(Shape shapeType) {

        if (shapeType == null) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new CircleExecuter();

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new RectangleExecuter();

        }
        return null;
    }
}