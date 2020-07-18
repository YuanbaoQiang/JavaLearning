/*
 * do-while循环的标准格式
 *
 * do{
 *   循环体
 * }while（条件判断）;
 *
 * 扩展格式：
 *
 * 初始化语句
 * do{
 *   循环体
 *   步进表达式
 * }while（条件判断）
 * */

public class Demon06Do{
    public static void main(String[] args){
        for(int i = 1; i<=10; i++){
            System.out.println("起来！"+i);
        }
        System.out.println("================");
        int i = 1;
        do{
            System.out.println("起来！"+i);
            i++;
        }while(i<=10);
    }
}