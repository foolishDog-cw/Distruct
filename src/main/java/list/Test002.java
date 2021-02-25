package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给出一个字符串 去掉重复的字符 输出新的字符串
 * @author Tedu
 */
public class Test002 {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入一行字符串:");
        String line=scanner.nextLine();
        char[] arr=line.toCharArray();
        List<Character> list=new ArrayList<>();
        for (char c : arr) {
            if (!list.contains(c)){
                list.add(c);
            }
        }
        for (Character c:list){
            System.out.print(new StringBuilder().append(c).toString());
        }
    }

}
