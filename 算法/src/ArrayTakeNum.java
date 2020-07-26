/**
 * <h3>算法</h3>
 * <p>定义一个整数数组，找出连续3个元素之和是最大的，并输出这三个元素</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 21:52
 **/

public class ArrayTakeNum {
    public static void main(String[] args) {
        // 定义一个整数数组
        int[] arr = new int[]{2, -6, 3, -9, 15, -10, 8};
        // 定义最大值为前三项
        int max = arr[0] + arr[1] + arr[2];
        // 定义一个索引
        int index = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int sum = arr[i] + arr[i+1] + arr[i+2];
            if(sum > max){
                max = sum;
                index = i;
            }
        }
        System.out.println("连续3个元素之和最大的三个数分别是："
                + arr[index] + "," + arr[index+1] + "," + arr[index+2]);
    }
}
