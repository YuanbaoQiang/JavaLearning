/*
 * continue关键字
 * 一旦执行，立刻跳过当前循环剩余次数，马上开始下一次循环
 *
 *
 * */

public class Demon10Continue{
    public static void main(String[] args){
        for(int i = 1; i <= 10; i++){
            if(i==4){ // 如果当前是第四层
                continue; // 那么跳过当次循环，马上开始下一次，就要打算循环
            }
            System.out.println(i+"层到了。");
        }
    }
}