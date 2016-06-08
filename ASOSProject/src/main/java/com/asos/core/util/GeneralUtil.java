package com.asos.core.util;

/**
 * Created by Umut on 27.4.2016.
 */
public class GeneralUtil {

    public static boolean stringToBoolean(String value){
        if (Integer.parseInt(value) == 0){
            return false;
        }
        return true;
    }
}
