package list;


import java.util.*;

/**
 * 随机输入一行字符串 将字符串中的每个字符 统计数量 并倒序排列
 * @author Tedu
 */
public class Test001 {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请随机输入一行字符串:");
        String line=scanner.nextLine();
        char[] arr=line.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int count=1;
        for (char c:arr){
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        ArrayList<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<Character,Integer> m:list){
            System.out.println(m);
        }
    }
}
