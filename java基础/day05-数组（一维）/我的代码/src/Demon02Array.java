// 静态数组定义
//
//
// 标准格式
// 数据类型[]  数据名称 = new 数据类型[] {元素1，元素2，元素3...}

// 省略格式
// 数据类型[] 数组名称 = {元素1，元素2，。。}

/*
*
* 注意事项
* 1. 静态初始化没有直接指定长度，但是仍然会自动推算到长度
* 2. 静态初始化标准格式可以拆成两个步骤
* 3. 动态初始化也可以拆成两个步骤
* 4. 静态初始化一旦使用省略格式，就不能拆分成两个步骤
* */

/*
* 使用建议
*
*
*
* */


public class Demon02Array {
    public static void mian(String[] args){

        // 标准格式
        int[] arrayA = new int[] {5,10,20};

        // 省略格式
        int[] arrayB = {5, 10, 20};


        // 创建一个数组，用来装字符串："HelloWorld", "Java"
        String[] arrayC = new String[] {"HelloWorld", "Java"};


        // 静态初始化可以拆成两个步骤
        int[] arrayD;
        arrayD = new int[] {10, 50, 60};

        // 动态初始化可以拆分成两个步骤
        int[] arrayE;
        arrayE = new int[10];
    }
}
