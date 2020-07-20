/*求出数组中的最大值*/
public class Demon05ArrayGetMax {
    public static void main(String[] args){
        int array[] = {1,1,5,15,1,4,7,3,5,67,4,6,0,7,8,3,4,5,3,6,3,7,9,49,8,5};

        // 求最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = array[i] > max ? array[i]:max;
        }
        System.out.println("最大值为："+ max);


        // 求最小值
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            min = array[i] < min ? array[i]:min;
        }
        System.out.println("最大值为："+ min);
    }
}
