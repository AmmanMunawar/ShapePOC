package com.ebricks.shape.config;

import com.ebricks.shape.Main;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {

    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    private static Configuration instance;
    private String shapeServiceUrl;

    private Configuration() {
    }

    public static Configuration getInstance() {

        if (instance == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                instance = objectMapper.readValue(new FileReader(System.getProperty("user.dir") + "/resources/config.json")
                        , Configuration.class);
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
        return instance;
    }

    public String getShapeServiceUrl() {
        return shapeServiceUrl;
    }

    public void setShapeServiceUrl(String shapeServiceUrl) {
        this.shapeServiceUrl = shapeServiceUrl;
    }
}
