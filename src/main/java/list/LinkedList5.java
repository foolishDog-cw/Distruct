package list;

import org.w3c.dom.Node;

/**
 * @author Tedu
 */
public class LinkedList5<E> {
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
        Node before=node.prev;
        Node after=node.next;
        before.next=after;
        after.prev=before;
        size--;
        if (node==head){
            head=after;
        }
        return node.data;
    }
    public void add(int index,E e){
        if (index>size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        if (index==size()){
            add(e);
            return;
        }
        Node node=getNode(index);
        Node newNode=new Node(e);
        Node before=node.prev;
        before.next=newNode;
        newNode.prev=before;
        newNode.next=node;
        node.prev=newNode;
        size++;
        if (index==0){
            head=newNode;
        }
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

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if (size==0){
            return "[]";
        }
        Node node=head;
        StringBuilder builder=new StringBuilder();
        builder.append("["+node.data);
        node=head.next;
        while (node!=head){
            builder.append(", "+node.data);
            node=node.next;
        }
        return builder.append("]").toString();
    }
}
