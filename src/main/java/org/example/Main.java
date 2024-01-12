package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static String repeat(String str, int times){
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
}