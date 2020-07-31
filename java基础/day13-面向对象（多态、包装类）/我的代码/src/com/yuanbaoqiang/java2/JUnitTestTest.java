package com.yuanbaoqiang.java2;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class JUnitTestTest {
    int num = 10;

    @Test
    public void testEquals() {
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));

/*
        Object obj = new String("GG");
        Date date = (Date)obj;
*/

        System.out.println(num);
        show();
    }

    public void show(){
        num = 20;
        System.out.println("show()...");
    }

    @Test
    public void testToString(){
        String s2 = "MM";
        System.out.println(s2.toString());
    }
}