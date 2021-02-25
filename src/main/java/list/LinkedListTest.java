package list;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Tedu
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        System.out.println(list.get(0));
        LinkedList<Integer> list1=new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println(list1);
        list1.remove(1);
        System.out.println(list1);
        LinkedList3<Integer> list3=new LinkedList3<Integer>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        System.out.println(list3);
        System.out.println(list3.size());
        System.out.println(list3.get(0));
        list3.remove(0);
        System.out.println(list3);
        list3.add(0,888);
        System.out.println(list3);
    }
}
