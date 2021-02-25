package list;

/**
 * @author Tedu
 */
public class LinkedList2<E> {
    private Node head;
    private int size;

    class Node {
        E data;
        Node next;
        Node prev;
        int index;
        public Node(E e) {
            data = e;
        }
    }

    public boolean add(E e) {
        Node node = new Node(e);
        if (head == null) {
            head = node;
            head.next = head;
            head.prev = head;
            head.index=0;
            size++;
            return true;
        }
        Node last = head.prev;
        last.next = node;
        node.next = head;
        node.prev = last;
        head.prev = node;
        node.index=last.index++;
        size++;
        return true;
    }
    public E get(int index){
        Node node=head;
        if (index>=size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        if (index<size()/2){
            for (int i = 0; i < index; i++) {
                node=node.next;
            }
        }else{
            for (int i = size(); i >index ; i--) {
                node=node.prev;
            }
        }
        return node.data;
    }
    public int size(){
        return size;
    }
    @Override
    public String toString() {
        if (head==null){
            return "[]";
        }
        StringBuilder builder=new StringBuilder();
        builder.append("["+head.data);
        Node node=head.next;
        while (node!=head){
            builder.append(","+node.data);
            node=node.next;
        }
        return builder.append("]").toString();
    }
}
