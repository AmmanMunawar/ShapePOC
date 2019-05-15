package com.ebricks.shape.executor;

import com.ebricks.shape.model.Shape;

public class ShapeFactory {

    private static ShapeFactory instance;

    private ShapeFactory() {
    }

    public static ShapeFactory getInstance() {

        if (instance == null) {
            instance = new ShapeFactory();
            return instance;
        }
        return instance;
    }

    //use getShape method to get object of type shape
    public ShapeExecutor getShapeExecuter(Shape shape) {

        if (shape == null) {
            return null;
        }

        if (shape.getType().equals("Circle")) {

            return new CircleExecuter(shape);

        } else if (shape.getType().equals("Rectangle")) {
            return new RectangleExecuter(shape);
        }
        return null;
    }

}