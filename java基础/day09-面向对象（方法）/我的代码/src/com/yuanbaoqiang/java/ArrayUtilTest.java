/**
 * <h3>我的代码</h3>
 * <p>测试创建的数组工具类</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 08:32
 **/

package com.yuanbaoqiang.java;

import java.awt.desktop.SystemEventListener;

public class ArrayUtilTest {
    public static void main(String[] args){
        ArrayUtil util = new ArrayUtil();
        int[] arr = new int[]{32,34,35,36,39,56,58,56,87,45,25};
        int max = util.getMax(arr);
        System.out.println("最大值为：" + max);
        int min = util.getMin(arr);
        System.out.println("最小值为：" + min);
        int sum = util.getSum(arr);
        System.out.println("总和为：" + sum);
        double ave = util.getAve(arr);
        System.out.println("平均数为：" + ave);
/*        // 反转数组
        util.reverse(arr);
        util.print(arr);
        System.out.println("*****************");
        // 冒泡排序
        util.sort(arr);
        util.print(arr);*/

        System.out.println("查找：");
        int index = util.getIndex(arr,-45);
        if(index >=0){
            System.out.println("找到了，索引地址为：" + index);
        }else{
            System.out.println("未找到该元素");
        }



    }
}
