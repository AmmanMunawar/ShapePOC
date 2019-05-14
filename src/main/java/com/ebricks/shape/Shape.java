package com.ebricks.shape;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class),
        @JsonSubTypes.Type(value = Rectangle.class, name = "Rectangle")
//        @JsonSubTypes.Type(value = Pentagon.class)
})
public class Shape{
    public Shape() {
    }

    public void draw(){

        System.out.println("Shape draw function");
    }


}