package com.ebricks.shape.service;

import com.ebricks.shape.config.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;

public class ServletService {

    private Configuration configuration;


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
            System.out.println("Error!! While Posting ");
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
            System.out.println("Successfully Posted");
        }

        else{
            System.out.println("Error!! While Posting ");
        }
    }

    public ServletService(){

        if(!Configuration.checkifobjectcreated()){

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                this.configuration = objectMapper.readValue(new FileReader("C:\\Users\\Aman Munawar\\IdeaProjects\\log4j2practise\\src\\main\\resources\\config.json"),Configuration.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
