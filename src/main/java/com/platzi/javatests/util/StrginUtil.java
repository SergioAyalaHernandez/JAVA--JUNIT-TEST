package com.platzi.javatests.util;

public class StrginUtil {
    public static String repeat(String str, int times){
       String result = "";

       if (times < 0){
           throw new IllegalArgumentException("negative times not allowed, by Sergio Ayala");
       }
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
}
