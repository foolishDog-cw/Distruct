package list;

/**
 * @author Tedu
 */
public class Test {
    public static void main(String[] args){
        LinkedList5<Integer> list=new LinkedList5<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.add(0,5);
        System.out.println(list+" "+list.size());
        list.remove(0);
        System.out.println(list+" "+list.size());
        list.add(3,899);
        System.out.println(list);
    }
}
