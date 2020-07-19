public class Demon03MethodSame {

    public static void main(String[] args){

        System.out.println(methodSame(5,6)); // false
        System.out.println(methodSame(12,12)); // false

    }

    public static boolean methodSame(int a, int b){
        // boolean result;
/*        if(a == b){
            result = true;
        }
        else{
            result = false;
        }*/

        /*boolean result = a==b ? true:false;*/

        // boolean result = a==b;

        return a==b;
    }
}
