package list;

/**
 * @author Tedu
 */
public class LinkedList4<E> {
    private Node head;
    private int size;
    class Node{
        E data;
        Node next;
        Node prev;
        public Node(E e){
            data=e;
        }
    }
    public boolean add(E e){
        Node node=new Node(e);
        if (head==null){
            head=node;
            head.next=head;
            head.prev=head;
            size++;
            return true;
        }
        Node last=head.prev;
        last.next=node;
        node.prev=last;
        node.next=head;
        head.prev=node;
        size++;
        return true;
    }
    public int size(){
        return size;
    }
    public E get(int index){
        if (index>=size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        return node.data;
    }
    public E remove(int index){
        if (index>=size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        if (size()==1){
            E data=head.data;
            head=null;
            size--;
            return data;
        }
        Node node=getNode(index);
        Node before = node.prev;
        Node after = node.next;
        before.next=after;
        after.prev=before;
        if (node==head){
            head=after;
        }
        size--;
        return node.data;
    }
    public boolean add(int index,E e){
        if (size()==0 && index==0){
            Node node=new Node(e);
            head=node;
            head.next=head;
            head.prev=head;
            size++;
            return true;
        }
        if (index>=size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        Node node=getNode(index);
        Node before=node.prev;
        Node newNode=new Node(e);
        before.next=newNode;
        newNode.prev=before;
        newNode.next=node;
        node.prev=newNode;
        if (index==0){
            head=newNode;
        }
        size++;
        return true;
    }
    private Node getNode(int index) {
        Node node=head;
        if (index <size() >> 1){
            for (int i = 0; i < index; i++) {
                node=node.next;
            }
        }else{
            for (int i = size(); i > index; i--) {
                node=node.prev;
            }
        }
        return node;
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
            builder.append(", "+node.data);
            node=node.next;
        }
        return builder.append("]").toString();
    }
}
