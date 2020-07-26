/**
 * <h3>算法</h3>
 * <p>让数组的每个位置去除以首位置的元素，得到的结果，作为该位置上的新值</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 22:21
 **/

public class ArrayPrint {
    public static void main(String[] args) {
        int[] arr = new int[]{12,3,3,34,56,77,432};

        // 从数组末尾开始for循环
        for(int i = arr.length - 1; i >=0; i--){
            arr[i] = arr[i]/arr[0];
        }

        // 遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
