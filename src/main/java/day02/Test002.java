package day02;

import java.util.Scanner;

/**
 * @author Tedu
 */
public class Test002 {
    private static int x=100;
    public static void main(String[] args) {
        getCount();
    }
    /**
     * 1. 写一个算法统计出一个字符串中某子串出现得次数。
     *
     *    ~~~java
     *    如：“hello ： helloworldhello  eclipse hello idea hello spring”中子串“hello”出现的次数
     */
    public static void getCount(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入一串字符串和要统计的子串以冒号分割:");
        String line=scanner.nextLine();
        String sonString=line.substring(0,line.indexOf(":"));
        line=line.substring(line.indexOf(":")+1);
        int count=0,index=0;
        while ((index=line.indexOf(sonString,index))!=-1){
            count++;
            index=index+1;
        }
        System.out.println(sonString+"出现了"+count+"次!");
    }
}
