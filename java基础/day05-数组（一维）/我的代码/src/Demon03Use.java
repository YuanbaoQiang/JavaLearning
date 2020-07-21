/*
* 使用动态初始化数组的时候，其中的元素将会自动拥有一个默认值。规则如下
*
* 如果是整数类型，那么默认为0；
* 如果是浮点类型，那么默认为0.0；
* 如果是字符类型，那么默认为'\u0000'
* 如果是布尔类型，那么默认为false
* 如果是引用类型，那么默认为null
*
* */

public class Demon03Use {
    public static void main(String[] args){
        int[] arrayA = new int[3];

        System.out.println(arrayA); // 内存地址值
        System.out.println(arrayA[0]); // 0
        System.out.println(arrayA[1]); // 0
        System.out.println(arrayA[2]); // 0

    }
}

/*
* Java的内存需要划分为5个部分：
*
* 1. 栈（stack）：存放的都是方法中的局部变量。
* 局部变量：方法的参数，或者是方法{}内部分变量
* 作用域：一旦超出作用域，立即从栈内存当中消失
*
* 2. 堆（Heap）：凡是new出来的东西，都在堆当中
* 堆内存中的东西都有一个地址值：16进制
*       如果是整数               默认为0
*       如果是浮点数             默认为0.0
*       如果是字符               默认为'\u0000'
*       如果是布尔               默认为false
*       如果是引用数据类型         默认为null
*
* 3. 方法区（Method Area）：存储.class相关信息，包含方法的信息
* 4. 本地方法栈（Native Method Stack）：与操作系统相关
* 5. 寄存器（pc Register）：与cpu相关
*
* */
