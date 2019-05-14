package com.ebricks.shape.config;

public class Configuration {

    private static boolean iscreated = false;
    private String urlString = "";

    public static boolean checkifobjectcreated(){

        if (iscreated==false){
            iscreated = true;
            return false;
        }
        return iscreated;
    }

    public void setUrlString(String urlString) {

        this.urlString = urlString;
    }

    public String getUrlString() {

        return urlString;
    }

    private Configuration() {

        this.urlString = urlString;
    }
}
