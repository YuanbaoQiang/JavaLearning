/**
 * <h3>我的代码</h3>
 * <p></p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-08-02 18:37
 **/

package com.yuanbaoqiang.exer3;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(3.4);
        ComparableCircle c2 = new ComparableCircle(3.5);

        int compareValue = c1.compareTo(c2);
        System.out.println(compareValue);

    }
}
