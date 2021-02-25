package day02;

/**
 * @author Tedu
 */
public class BinaryTree1<E extends Comparable<E>> {
    private Node root;
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
            }else if (flag<0){
                if (right==null){
                    right=new Node(e);
                }else{
                    return right.append(e);
                }
            }else{
                return false;
            }
            return true;
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
}
