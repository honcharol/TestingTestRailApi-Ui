package com.ex.ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public String prop(String prop){
        Properties property = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("config.properties");
        try {
            property.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return property.getProperty(prop);
    }

//    // second variant:
//    public static void main(String[] args) {
//        InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties") ;
//
//            Properties property = new Properties();
//        try {
//            property.load(input);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//            System.out.println(property.getProperty("uri"));
//            System.out.println(property.getProperty("email"));
//            System.out.println(property.getProperty("password"));
//
////        return property.getProperty(prop);
//    }
}
