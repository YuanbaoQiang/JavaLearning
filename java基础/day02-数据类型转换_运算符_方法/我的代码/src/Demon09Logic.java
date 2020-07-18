/*
 * 逻辑运算符
 * 与（并且）  &&全都是 true  才是true  否则就是false
 * 或（或者）  ||至少是一个true  才是true  全是false 才是false
 * 非（取反）  ！本来是true  变成false
 *
 * 与&&  或||具有短路效果，如果根据左边就可以判断出最终结果，那么右边的代码将不再执行，从而节省一定的性能
 *
 * 注意事项
 * 1. 逻辑运算符只可以永福boolean值
 * 2. 与、或需要左右都有一个boolean值，但是取反只要有唯一的一个boolean值即可
 * 3. 与或 如果有多个条件，可以连续写
 * */

public class Demon09Logic{
    public static void main(String[] args){
        System.out.println(true && false);
        System.out.println(3<4 && 10<20);
        System.out.println(false || false);
        System.out.println(true || false);
        System.out.println(!true);

        int a = 10;
        System.out.println(3>4 && ++a < 100);
        System.out.println(a);
    }
}