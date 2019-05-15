package com.ebricks.shape.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        visible = true,
        property = "type"
)
@JsonSubTypes({

        @JsonSubTypes.Type(value = Circle.class, name = "Circle"),
        @JsonSubTypes.Type(value = Rectangle.class,name = "Rectangle")

})
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        visible = true,
//        property = "type"
//        )
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Circle.class, name = "Circle")
//)}



public class Shape{
//    @JsonProperty("type")
    private String type;
    public Shape() {
    }

    public void draw(){
        System.out.println("Shape draw function");
    }
//    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Shape> createShapeList(){

        List<Shape> shapeList = new ArrayList<>();
        Circle circle = new Circle(1,2,3);
        Rectangle rectangle = new Rectangle(2,3,1,4);
        shapeList.add(circle);
        shapeList.add(rectangle);
        return shapeList;

    }


}