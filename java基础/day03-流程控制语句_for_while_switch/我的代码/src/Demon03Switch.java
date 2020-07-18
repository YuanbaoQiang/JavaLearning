// 选择语句 switch
/*
 * 注意事项
 * 1. 多个case后面的数值不可以重复
 * 2. switch后面小括号当中只能是以下数据类型
 * 基本数据类型：byte/short/char/int
 * 引用数据类型：String字符串、enum枚举
 * 3. switch语句可以很灵活，前后顺序可以颠倒，而且break语句可以省略，但是会一直向下执行，知道有break语句或者整体结束为止
 *
 * */
public class Demon03Switch{
    public static void main(String[] args){
        int num = 1;
        switch (num){
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("数据不合理");
                break;

        }
    }
}