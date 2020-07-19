
// 定义个一个方法  求出1-100所有的数字和

public class Demon04Sum {
    public static void main(String[] args){
        System.out.println(sum(1,100));

    }

    // 定义了【a,b】的所有数字和
    public static int sum(int a, int b){
        int count = 0;
        for (int i = a; i < b+1; i++) {
            count +=i;
        }
        return count;
    }
}
