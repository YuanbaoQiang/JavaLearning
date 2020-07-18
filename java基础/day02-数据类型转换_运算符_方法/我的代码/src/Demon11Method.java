/*
 *定义一个方法的格式
 *
 * public static void methodName(){
 * 方法体
 * }
 *
 *
 * 方法名称的命名规则和变量一样，使用小驼峰
 * 方法体，也就是大括号当中可以包括任意条语句
 *
 * 注意事项
 * 1. 方法定义的先后顺序无所谓
 * 2. 方法的定义不能产生嵌套包含关系
 * 3. 方法定义好了之后，不会执行的，如果要执行，一定要进行方法的【调用】
 *
 *
 * 【调用】
 * 方法名称（）：
 * */


public class Demon11Method{
    public static void main(String[] args){
        // 调用农民伯伯的方法
        farmer();

        // 调用小商贩的方法
        seller();

        // 调用厨子的方法
        cook();

        // 调用我的方法
        me();

    }
    public static void farmer(){
        // 农民伯伯
        System.out.println("播种");
        System.out.println("浇水");
        System.out.println("除虫");
        System.out.println("收割");
        System.out.println("卖给小商贩");
    }

    public static void seller(){
        //小商贩
        System.out.println("运输到农贸市场");
        System.out.println("抬高价格");
        System.out.println("吆喝");
        System.out.println("装盘");
    }

    public static void cook(){
        //厨子
        System.out.println("洗菜");
        System.out.println("切菜");
        System.out.println("炒菜");
        System.out.println("装盘");
    }

    public static void me(){
        System.out.println("吃");
    }
}