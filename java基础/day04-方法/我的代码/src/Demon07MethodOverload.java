/*
* 对于功能类似的方法来说，因为参数列表不一样，却需要记住那么多不同的方法名称，添麻烦
*方法的重载（Overload）多个方法的名称一样，但是参数列表不一样
*
* 好处：
* 只需记住唯一一个方法名称，就可以首先类似的多个功能
*
* 方法重载与下列因素有关：
* 1. 参数个数不同
* 2. 参数类型不同
* 3. 参数的多类型顺序不同
*
* 方法重载与下列因素无关：
* 1. 与参数的名称无关
* 2.  与返回值的类型无关
*
* */
public class Demon07MethodOverload {
    public static void main(String[] args){
        System.out.println(sum(10, 20)); // 两数相加
        System.out.println(sum(10, 20, 30)); // 三个数相加
        System.out.println(sum(10, 20, 30, 40)); // 四个数相加

        for (int i = 0; i < 10; i++) {
            
        }
    }

    public static int sum(int a, int b){
        System.out.println("有两个参数即可");
        return a + b;
    }

    public static int sum(int a, int b, int c){
        System.out.println("有三个参数即可");
        return a + b + c;
    }

    public static int sum(int a, int b, int c, int d){
        System.out.println("有三个参数即可");
        return a + b + c + d;
    }


    public static int sum(int a, double b){
        return (int) (a + b);
    }

    public static int sum(double a, int b){
        return (int) (a + b);
    }

    public static int sum(double a, double b){
        return (int) (a + b);
    }


    // 错误写法：与方法的返回值类型无关
    /*public static double sum(int a, int b){
        return a + b;
    }*/

    // 错误写法：与参数的名称无关
    /*public static int sum(int x, int y){
        return x + y;
    }*/
}


