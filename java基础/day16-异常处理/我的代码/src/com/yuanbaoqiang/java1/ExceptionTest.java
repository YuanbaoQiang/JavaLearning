/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-06 13:20
 **/

package com.yuanbaoqiang.java1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

public class ExceptionTest {



    /*********************编译时异常********************/
    @Test
    public void test7(){
/*    File file = new File("hello.text");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){
            System.out.println((char)data);
            data = fis.read();
        }
        fis.close();*/
    }


    /*********************运行时异常********************/
    // java.lang.ArithmeticException
    @Test
    public void test6(){
        int a = 10;
        int b = 0;
        System.out.println(a/b);
    }

    // java.util.InputMismatchException
    @Test
    public void test5(){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);
        scanner.close();
    }



    // java.lang.NumberFormatException
    @Test
    public void test4(){
        String str = "123";
        str = "abc";
        int num = Integer.parseInt((str));
    }


    // java.lang.ClassCastException
    @Test
    public void test3(){
        Object obj = new Date();
        String str = (String)obj;
    }



    // java.lang.ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
/*        int[] arr = new int[10];
        System.out.println(arr[10]);*/

        // java.lang.StringIndexOutOfBoundsException
        String str = "abc";
        System.out.println(str.charAt(3));

    }



    // java.lang.NullPointerException
    @Test
    public void test1(){
/*        int[] arr = null;
        System.out.println(arr[2]);*/
        String str = "abc";
        str = null;
        System.out.println(str.charAt(1));


    }
}
