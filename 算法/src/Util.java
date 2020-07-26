/**
 * <h3>算法</h3>
 * <p>算法工具类</p>
 *
 * @author : YuanbaoQiang
 * @date : 2020-07-26 21:49
 **/

public class Util {
    /**
     * @description: 1-n 之和
     * @author: YuanbaoQiang
     * @date: 2020/7/26 20:02
     * @param n
     * @return: int
     */
    public int getSum(int n){
        if(n == 1){
            return 1;
        }else{
            return n + getSum(n-1);
        }
    }


    /**
     * @description: n!
     * @author: YuanbaoQiang
     * @date: 2020/7/26 20:06
     * @param n
     * @return: int
     */
    public int getProduct(int n){
        if(n == 1){
            return 1;
        }else{
            return n * getProduct(n-1);
        }
    }


    /**
     * @description: 斐波那契数列：1、1、2、3、5、8、13、21、34、……
     * @author: YuanbaoQiang
     * @date: 2020/7/26 20:15
     * @param n
     * @return: int
     */
    public int getFibonacci(int n){
        if(n == 1 ){
            return 1;
        }else if(n == 2){
            return 1;
        }else{
            return getFibonacci(n-1) + getFibonacci(n-2);
        }
    }

    /**
     * @description: 汉诺塔问题
     * @author: YuanbaoQiang
     * @date: 2020/7/26 20:40
     * @param num
     * @param A
     * @param B
     * @param C
     * @return: void
     */
    public void hanNuo(int num, char A, char B, char C){
        if(num == 1){
            System.out.println(A + "-->" + C);
        }else{
            hanNuo(num-1, A, C, B); // 将num-1个圆盘从A转移到B
            System.out.println(A + "-->" + C);
            hanNuo(num-1, B, A, C); // 将num-1个圆盘从B转移到C
        }
    }
}
