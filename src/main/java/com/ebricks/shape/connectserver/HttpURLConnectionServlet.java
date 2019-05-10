package com.ebricks.shape.connectserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionServlet {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "http://localhost:8080/demoservlet/Shapes";
    private static final String POST_URL = "http://localhost:8080/demoservlet/Shapes";

    public static void sendGET() throws IOException {

        URL urlObject = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlObject.openConnection();
        httpURLConnection.setRequestMethod("GET");
        if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpURLConnection.getInputStream()));

            String inputLine;
            StringBuffer stringBuffer = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            reader.close();

            // print result
            System.out.println(stringBuffer.toString());
        } else {
            System.out.println("GET request not worked");
        }
        httpURLConnection.disconnect();
    }

    public static void sendPOST() throws IOException {

        String shapejsonstring  = "{\"shapes\":[{\"@type\":\"Circle\",\"x\":12121,\"y\":32,\"radius\":34},{\"@type\":\"Rectangle\",\"x\":12,\"width\":34,\"y\":32,\"height\":23}]}";
        URL urlObject = new URL(POST_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlObject.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        OutputStream os = httpURLConnection.getOutputStream();
        os.write(shapejsonstring.getBytes());
        os.flush();
        os.close();
        if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

            System.out.println("Successfully Posted");

        }

        else{

            System.out.println("Error!! While Posting ");

        }
    }
}
