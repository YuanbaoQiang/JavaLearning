/**
 * <h3>JavaSenior</h3>
 * <p>自定义泛型类</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-20 09:46
 **/

package com.yuanbaoqiang.java;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {

    String orderName;
    int orderId;


    //类的内部就可以使用类的泛型
    T orderT;

    public Order(){
        // 编译不通过
        // T[] arr = new T[10];

        T[] arr = (T[]) new Object[10];
    };

    public Order(String orderName, int orderId, T orderT){
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // 静态方法中不可以使用
/*    public static void show(T orderT){
        System.out.println(orderT);
    }*/

    public void show(){
        // 编译不通过
/*        try{

        }catch(T t){

        }*/
    }

    // 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何
    // 换句话说，泛型方法所属的类是不是泛型类都没有关系
    // 泛型方法，可以声明为静态的。原因：泛型参数是在带哦用方法时确定的，并非在实例化类时确定
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }


}
