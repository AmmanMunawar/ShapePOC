package com.ebricks.shape.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class),
        @JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle")

})

public class Shape{

    public void draw(){
        System.out.println("Shape draw function");
    }

    public List<Shape> createShapeList(){

        List<Shape> shapeList = new ArrayList<>();
        Circle circle = new Circle(1,2,3);
        Rectangle rectangle = new Rectangle(2,3,1,4);
        shapeList.add(circle);
        shapeList.add(rectangle);
        return shapeList;

    }

    public Shape() {
    }
}