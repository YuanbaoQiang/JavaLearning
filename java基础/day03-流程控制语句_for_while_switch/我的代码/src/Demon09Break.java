
/*
 * break关键字的用法有常见的两种
 *
 * 1. 可以用在switch语句当中，一旦执行，整个switch语句立马结束；
 * 2. 还可以用再循环语句中，一旦执行，整个循环语句立刻结束
 * */
public class Demon09Break{
    public static void main(String[] args){
        for(int i = 1; i < 10; i++){
            //如果希望从第四次开始，后续全都不要了，就要打断循环
            if(i==4){
                break; // 打断整个循环
            }
            System.out.println("Hello"+i);
        }
    }
}