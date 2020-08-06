package com.yuanbaoqiang.java; /**
 * <h3>我的代码</h3>
 * <p>异常概述</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-06 11:43
 **/

/*
* Error：
* Java虚拟机无法解决的严重问题。
*
*
*
* */


public class ErrorTest {
    public static void main(String[] args) {
        // 1. 栈溢出：Java.lang.StackOverflowError
        // main(args);

        // 2. 堆溢出：java.lang.OutOfMemoryError
        Integer[] arr = new Integer[1024*1024*1024];


    }

}
