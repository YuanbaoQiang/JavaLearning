// 求出1-100之间的偶数和
public class Demon07Test{
    public static void main(String[] args){
        int count = 0;
        int num = 0;
        int j = 1;
        for(int i=1; i<=100; i++){
            if(i%2==0){
                count = count + i;
            }
            num++;
        }

         while(j<=100){
            if(j%2==0){
                count = count + j;
            }
            j++;
            num++;
        }

         do{
            if(j%2==0){
                count =count + j;
            }
            j++;
            num++;

        }while(j<=100);

        System.out.println(num+" "+count);
    }

}