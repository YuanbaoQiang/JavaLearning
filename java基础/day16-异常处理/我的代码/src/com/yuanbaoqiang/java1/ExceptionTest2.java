/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-06 16:07
 **/

package com.yuanbaoqiang.java1;

/*
* 异常处理的方式二：throws + 异常类型
*
* 1. “throws + 异常类型” 写在方法的声明出，指明此方法执行时，可能会抛出异常类型
*     一旦当方法体执行时，出现异常，仍然在异常的代码处生成一个异常类的对象，此对象满足throws后异常类型时，就会抛出。
*     异常代码后续的代码，就不再执行！！
* 2. 体会：try-catch-finally：真正的将异常给处理掉了
*       throws的方式只是将异常抛给了方法的调用者，并没有真正的将异常处理掉
*
* 3. 开发中如何选择使用try-catch-finally还是使用throws？
*       3.1 如果父类中被重写的方法没有throws方法处理异常，则子类重写的方法也不能使用throws，意味着如果子类重写的方法有异常
*           必须使用try-catch-finally方式处理
*       3.2 执行的方法中，先后又调用了另外的几个方法，这几个方法是递进关系执行的，
*           建议方法使用throws的方式处理，而执行的方法a可以考虑用try-catch-finaly方式处理
*
*
* */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest2 {

    public static void main(String[] args){
        method3();
    }

    @Test
    public static void method3(){
        try{
            method2();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    @Test
    public static void method2() throws IOException{
        method1();
    }


    @Test
    public static void method1() throws FileNotFoundException, IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){
            System.out.print((char)data);
            data = fis.read();
        }
        fis.close();
    }
}
