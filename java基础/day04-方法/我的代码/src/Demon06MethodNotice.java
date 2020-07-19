/*
* 注意事项：
* 1. 方法应该定义在类当中，但是不可以在方法中再定义方法。不能嵌套
* 2. 方法定义的前后顺序无所谓
* 3. 方法定义之后，如果希望执行，一定要调用：单独调用，打印调用，赋值调用
* 4. 如果方法有返回值，那么必须写 "return 返回值"，不能没有
* 5. return后面的返回值类型，必须和方法的返回值类型，对应起来
* 6. 对于void没有返回值的方法，不能写return后面的返回值，只能写return。
* 7. 对于void方法的最后一行return也可以不写
* 8. 一个方法当中有多个return语句，但是必须保证只有一个被执行到
*/
public class Demon06MethodNotice {
    public static int method1(){
        return 10;
    }

    public static void method2(){
        // retun 10; 错误写法
        return; // 没有返回值，只是结束方法的执行而已
    }

    public static void method3(){
        System.out.println("AAA");
        System.out.println("BBB");
        // return; 可以写 可以不写
    }

    public static int getMax(int a, int b){
        int max = a>b ? a:b;
        return max;
    }
}
