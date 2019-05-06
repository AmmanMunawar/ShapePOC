package com.ebricks.shape;

import com.ebricks.shape.processor.ShapeProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.rmi.server.ExportException;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        LOGGER.fatal("This is Main Class");
        ShapeProcessor shapeProcessor = new ShapeProcessor();
        try {
            shapeProcessor.init();
            shapeProcessor.process();
        }
        catch (ExportException e){
            System.out.println(e);
        }
        finally {
            shapeProcessor.end();
        }

    }
}
