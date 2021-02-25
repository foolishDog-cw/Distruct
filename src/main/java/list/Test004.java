package list;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Tedu
 */
public class Test004 {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入一行字符串....");
        String line=scanner.nextLine();
        char[] arr=line.toCharArray();
        ArrayList<Character> list=new ArrayList<>();
        for (char c:arr){
            if (!list.contains(c)){
                list.add(c);
            }
        }
        for (Character c:list){
            System.out.print(c);
        }
    }
}
