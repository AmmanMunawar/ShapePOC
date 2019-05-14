package com.ebricks.shape.executor;

public class ShapeFactory {

    //use getShape method to get object of type shape
    public ShapeExecutor getShape(String shapeType) {

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