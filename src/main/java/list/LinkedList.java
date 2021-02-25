package list;

import org.w3c.dom.Node;

/**
 * @author Tedu
 * 双向循环链表类
 */
public class LinkedList<E>{
    /**
     * head用于存放头结点的引用
     * size用于存放链表的长度
     */
    private Node head;
    private int size;
    /**
     * Node类用于描述链表中的节点
     * 其中,data用于存放数据(即元素)
     * next和pre用于存放后继节点和前驱节点的引用
     */
    class Node{
        E data;
        Node next;
        Node prev;
        int index;
        public Node(E e) {
            this.data = e;
        }
    }

    /**
     * 将元素添加到链表的末尾
     * @param e 要添加的元素
     * @return 添加成功 返回true
     */
    public boolean add(E e){
        Node node=new Node(e);
        if (head==null){
            head=node;
            head.prev=head;
            head.next=head;
            head.index=0;
            size++;
            return true;
        }
        Node last=head.prev;
        //最后一个元素的后继节点
        last.next=node;
        //添加元素的后继节点
        node.next=head;
        //添加元素的前驱节点
        node.prev=last;
        //头结点的前驱节点
        head.prev=node;
        node.index=last.index++;
        size++;
        return true;
    }
    public E get(int index){
        Node node=head;
        if (index>=size() || index<0){
            throw new IndexOutOfBoundsException();
        }
        if (index<size() >> 1){
            for (int i = 0; i <index; i++) {
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
        StringBuilder builder=new StringBuilder();
        if (head==null){
            return "[]";
        }
        builder.append("["+head.data);
        Node node=head.next;
        while (node!=head){
            builder.append(","+node.data);
            node=node.next;
        }
        return builder.append("]").toString();
    }
}
