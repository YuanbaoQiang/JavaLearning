// 命名规范
// 类名规范：首字母大写，后面每个单词首字母都大写：HelloWorld, PolymerTesting
// 变量名规范：首字母小写，后面每个单词首字母大写：max_count, min_value


/*
 * 常量：在程序运行期间，固定不变的量
 *
 * 常量的分类：
 * 1. 字符串常量：双赢
 * 2. 整数常量：整数，无小数点
 * 3. 浮点数常量：小数，有小数点
 * 4. 字符常量：单引号的内容，
 * 5. 布尔常量：true, false
 * 6. 空常量：null，代表没有任何数据。
 * */

public class Demo01Count{
    public static void main(String[] args){
        // 字符串常量
        System.out.println("ABC");
        System.out.println("");
        // 字符常量
        System.out.println('A');
        System.out.println('d');
        // System.out.println('');
        System.out.println(' '); //单引号内必须有字符！！！空格也算一个字符
        // 浮点数常量
        System.out.println(40.5);
        // 布尔常量
        System.out.println(true);
        System.out.println(false);
        // 空常量
        // System.out.println(null); // 错误写法
        System.out.println(100L);
    }
}