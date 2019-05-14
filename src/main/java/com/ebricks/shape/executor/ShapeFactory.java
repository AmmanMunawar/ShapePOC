package com.ebricks.shape.executor;

import com.ebricks.shape.model.Shape;

public class ShapeFactory {

    //use getShape method to get object of type shape
    public ShapeExecutor getShapeExecuter(Shape shapeType) {

        if (shapeType == null) {
            return null;
        }

        if (shapeType.getClass().getSimpleName().equalsIgnoreCase("CIRCLE")) {
            return new CircleExecuter(shapeType);

        } else if (shapeType.getClass().getSimpleName().equalsIgnoreCase("RECTANGLE")) {
            return new RectangleExecuter(shapeType);

        }
        return null;
    }
}