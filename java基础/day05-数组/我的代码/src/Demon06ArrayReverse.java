/*
* 数组元素的反转：
* 本来的样子：[1,2,3,4]
* 之后的样子：[4,3,2,1]
* */

public class Demon06ArrayReverse {
    public static void main(String[] args){
        int array[] = {10,20,30,50,60};

        // 遍历打印数组本来的样子
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        /*
        * 初始化语句：int min = 0, max = array.length-1
        * 条件判断: min < max
        * 步进表达式: min++, max--
        * */

        for(int min = 0, max = array.length-1; min < max; min++, max--){
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }

        System.out.println();

        // 再次遍历打印数组
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }
}
