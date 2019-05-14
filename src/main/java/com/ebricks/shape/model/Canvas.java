package com.ebricks.shape.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Canvas {
    private List<Shape> shapeList;

    public Canvas(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    public Canvas() {
    }
    public List<Shape> getShapeList() {
        return shapeList;
    }

    public void setShapeList(List<Shape> shapeList) {
        this.shapeList = shapeList;
    }
}
