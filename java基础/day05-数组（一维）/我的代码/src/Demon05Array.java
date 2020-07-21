/*
* 遍历数组，说的就是对数组当中的每一格元素进行逐一、挨个处理，默认的处理方式就是打印输出
* */

public class Demon05Array {
    public static void main(String[] args){
        int array[] = {1,5,2,0,5,5,9,5,5,6,4,1,6,5,6,5,6,2,32,3};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
