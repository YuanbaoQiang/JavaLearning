/**
 * <h3>JavaSenior</h3>
 * <p>
 *
 *     java内置的4大核心函数式接口
 *
 *     消费型接口 Consumer<T>        accept(T t)
 *     供给型接口 Supplier<T>        T get()
 *     函数型接口 Function<T, R>     R apply(T t)
 *     断定型接口 Predicate<T>       boolean test(T t)
 *
 *
 * </p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-25 15:18
 **/

package com.yuanbaoqiang.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest2 {


    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累~~~");
            }
        });

        System.out.println("**************************************");

        happyTime(500,money -> System.out.println("学习太累~~~"));

    }


    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }



    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","天津","南京","东京","普京");

        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterStrs);

        List<String> filterStrs2 = filterString(list,s -> s.contains("京"));



    }


    // 根据给定的规则，过滤集合中的字符串。此规则由Predicated的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }


}
