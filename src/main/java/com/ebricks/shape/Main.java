package com.ebricks.shape;

import com.ebricks.shape.processor.ShapeProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {

        ShapeProcessor shapeProcessor = new ShapeProcessor();
        try {

            shapeProcessor.init();
            shapeProcessor.process();

        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            shapeProcessor.end();
        }

    }
}