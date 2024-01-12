package com.platzi.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StrginUtilTest {

    @Test
    public void repeat_string_once(){
        Assert.assertEquals("hola",StrginUtil.repeat("hola",1));
    }
    @Test
    public void repeat_string_multiple_times(){
        Assert.assertEquals("holaholaholahola",StrginUtil.repeat("hola",4));
    }
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){
        StrginUtil.repeat("hola",-1);
    }

    @Test
    public void testRepeatManual(){
        //Forma manual de hacer un test unitario
        assertEquals(StrginUtil.repeat("hola",3), "holaholahola");
        assertEquals(StrginUtil.repeat("hola",1), "hola");
        // error en la prueba
        // assertEquals(StrginUtil.repeat("hola",2), "hola");
    }



    //metodo para hacer un test unitario especifico, cómo teoria de un test unitario
    private static void assertEquals(String actual,String expected) {

        if(!actual.equals(expected)){
            throw new RuntimeException(actual + "is not equal to " + expected);
        }
    }
}