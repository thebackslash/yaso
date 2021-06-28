package com.sapient.util;

import java.util.ResourceBundle;

public class GetProperties {



    public static String getProperty(String name){
        ResourceBundle rb = ResourceBundle.getBundle("resources");
        return rb.getString("URI");
    }
}
