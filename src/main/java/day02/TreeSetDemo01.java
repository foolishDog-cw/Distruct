package day02;

import java.util.TreeSet;

/**
 * 演示红黑树特点
 * 注: TreeSet调用了TreeMap对象的方法来添加、删除、修改数据
 *     TreeMap是一颗红黑树
 * @author Tedu
 */
public class TreeSetDemo01 {
    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<>();
        s.add(88);
        s.add(66);
        s.add(33);
        s.add(22);

    }
}
