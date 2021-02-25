package list;

import org.w3c.dom.Node;

/**
 * @author Tedu
 */
public class LinkedList3<E>{
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

    /**
     * 依据下标找到某个节点
     * 这是一个帮助器(helper方法),即只在当前类中使用
     * @param index
     * @return
     */
    private Node getNode(int index) {
        Node node=head;
        if (index < size()>>1){
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

    public E remove(int index){
        if (index>=size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        if (size()==1){
            E data=head.data;
            head=null;
            return data;
        }
        Node node=getNode(index);
        Node before=node.prev;
        Node after=node.next;
        before.next=after;
        after.prev=before;
        if (node==head){
            head=after;
        }
        size--;
        return node.data;
    }
    public void add(int index,E e){
        if (size()==0){
            head=new Node(e);
            head.prev=head;
            head.next=head;
            size++;
            return;
        }
        if (index>=size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        Node node=getNode(index);
        Node addNode=new Node(e);
        Node before=node.prev;
        before.next=addNode;
        addNode.next=node;
        addNode.prev=before;
        node.prev=addNode;
        if (index==0){
            head=addNode;
        }
        size++;
    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        if (head==null){
            return "[]";
        }
        StringBuilder b=new StringBuilder();
        b.append("["+head.data);
        Node node=head.next;
        while (node!=head){
            b.append(", "+node.data);
            node=node.next;
        }
        return b.append("]").toString();
    }
}
