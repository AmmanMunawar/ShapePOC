package com.ebricks.shape.service;

import com.ebricks.shape.config.Configuration;
import com.ebricks.shape.processor.ShapeProcessor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;

public class ShapeService {

    private static final Logger LOGGER = LogManager.getLogger(ShapeProcessor.class.getName());
    private Configuration configuration = Configuration.getInstance();

    public ShapeService(){

    }

    public String downloadShapes() throws IOException {

        String getURL = this.configuration.getUrlString() + "/demoservlet/Shapes";
        HttpClient shapeHttpClient = HttpClientBuilder.create().build();
        HttpGet shapeGetRequest = new HttpGet(getURL);
        HttpResponse response = shapeHttpClient.execute(shapeGetRequest);
        String content = EntityUtils.toString(response.getEntity());
        if (response.getStatusLine().getStatusCode() == 200) {
            return content;
        }

        else{
            LOGGER.error("Error!! While Posting ");
        }
        return "Could not get";
    }

    public void postShape(String payload) throws IOException {

        String postURL = this.configuration.getUrlString() + "/demoservlet/Shapes";
        HttpClient shapeHttpClient = HttpClientBuilder.create().build();
        HttpPost shapePostRequest = new HttpPost(postURL);
        StringEntity entity = new StringEntity(payload);
        shapePostRequest.setEntity(entity);
        HttpResponse response = shapeHttpClient.execute(shapePostRequest);

        if (response.getStatusLine().getStatusCode() == 200) {
            LOGGER.info("Successfully Posted");
        }

        else{
            LOGGER.error("Error!! While Posting ");
        }
    }
}
