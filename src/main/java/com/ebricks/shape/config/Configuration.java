package com.ebricks.shape.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {

    private static Configuration instance = null;
    private String urlString = "";

    private Configuration() {

        this.urlString = urlString;
    }

    public void setUrlString(String urlString) {

        this.urlString = urlString;
    }

    public String getUrlString() {

        return urlString;
    }

    public static Configuration getInstance() {

        if (instance==null){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                instance = objectMapper.readValue(new FileReader("C:\\Users\\Aman Munawar\\IdeaProjects\\log4j2practise\\src\\main\\resources\\config.json")
                        ,Configuration.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
