// 赋值运算符分为
// 基本赋值运算符：就是一个等号“=”，代表将右侧的数据交给左侧的变量

// 复合赋值运算符：
//       +=      a +=1       a = a + 1
//       -=      b -=1       b = a - 1
//       */      c *=5       c = c * 5
//       /=      d /=6       d = d / 6
//       %=      e %=7       e = e % 7

/*
 * 注意事项：
 * 1. 只有变量才能使用赋值运算符，常量不能进行赋值
 * 2. 符合赋值运算
 * */

public class Demon07Operator{
    public static void main(String[] args){
        int a = 10;
        a +=5;
        System.out.println(a); // 15
    }
}