/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-06 16:23
 **/

package com.yuanbaoqiang.java1;

/*
*
* 方法重写的规则之一：
* 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
*
*
*
* */


import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest {

    public static void main(String[] args) {
        OverrideTest test = new OverrideTest();
        test.display(new Subclass());

    }




    public void display(SuperClass s){
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class SuperClass{

    public void method() throws IOException {

    }


}


class Subclass extends SuperClass{
    @Override
    public void method() throws FileNotFoundException {

    }
}