package day02;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tedu
 * 泛型E 必须要实现Comparable<E>接口 因为该泛型必须能够比较大小
 */
public class BinaryTree<E extends Comparable<E>> {
    /**
     * root用于保存根节点的引用
     */
    private Node root;

    /**
     * Node类用于描述二叉树中的某个节点
     * data用于存放数据(即元素)
     * left和right用于存放其左右子树的引用.
     */
    class Node{
        E data;
        Node left;
        Node right;
        public Node(E e){
            data=e;
        }

        public boolean append(E e) {
            int flag=data.compareTo(e);
            if (flag>0){
                if (left==null){
                    left=new Node(e);
                }else{
                    return left.append(e);
                }
            }else if (flag==0){
                return false;
            }else{
                if (right==null){
                    right=new Node(e);
                }else{
                    return right.append(e);
                }
            }
            return true;
        }
        
        public String find(StringBuilder builder,List<Node> list,int i) {
            if (left==null){
                builder.append(data);
                if (right==null){
                    i++;
                    builder.append(list.get(list.size()-i).data);
                    if (i==list.size()){
                        return builder.toString();
                    }
                    return list.get(list.size()-i).right.find(builder,list,i);
                }else{
                    return right.find(builder,list,i);
                }
            }else{
                list.add(this);
                return left.find(builder,list,i);
            }
        }
    }
    public boolean add(E e){
        Node node=new Node(e);
        if (root==null){
            root=node;
            return true;
        }
        return root.append(e);
    }
    public String iterator(){
        if (root==null){
            return null;
        }
        int i = 0;
        List<Node> list=new ArrayList<Node>();
        StringBuilder builder=new StringBuilder();
        return root.find(builder,list,i);
    }
}
