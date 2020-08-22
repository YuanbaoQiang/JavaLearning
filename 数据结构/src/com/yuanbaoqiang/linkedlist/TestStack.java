/**
 * <h3>DataStructures</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-20 20:54
 **/

package com.yuanbaoqiang.linkedlist;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.add("Jack");
        stack.add("Tom");
        stack.add("Smith");

        // 出栈
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
