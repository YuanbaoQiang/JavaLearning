/*
 * 数字和字符的对照关系表（编码表）：
 * ASCII码表 American Stantard Code for Information Interchange：美国信息交换标准代码
 * Unicode码表：万国码。也是数字和符号的对照关系，开头0-127部分和ASCII完全一样，但是从128开始包含有更多符号
 *
 * 48 - '0'
 * 65 - 'A'
 * 97 - 'a'
 * */

public class Demon03DataTypeChar{
    public static void main(String[] args){
        char zifu1 = '1';
        System.out.println(zifu1+0);

        char zifu2 = 'A';
        System.out.println(zifu2);

        char zifu3 = 'a';
        int num1 = zifu3;
        System.out.println(num1);
    }
}