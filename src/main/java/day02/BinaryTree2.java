package day02;

import org.w3c.dom.Node;

/**
 * @author Tedu
 */
public class BinaryTree2<E extends Comparable<E>> {
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
                    return true;
                }else{
                    return left.append(e);
                }
            }else if (flag<0){
                if (right==null){
                    right=new Node(e);
                    return true;
                }else{
                    return right.append(e);
                }
            }else{
                return false;
            }
        }

        /**
         * 递归:我这一层解决不了，继续往下解析，直到解析到最后一层找到了答案，然后再一层一层的回溯
         * 对当前节点进行中序遍历
         * @param builder
         * @return
         */
        public void inOrder(StringBuilder builder) {
            //如果当前节点的左子树不为空，则对其左子树进行中序遍历
            if (left!=null){
                left.inOrder(builder);
            }
            builder.append(data+", ");
            if (right!=null){
                right.inOrder(builder);
            }
        }
    }

    /**
     * 将元素添加到二叉树上
     * @param e  要添加的元素
     * @return 添加成功返回true否则返回false
     */
    public boolean add(E e){
        //如果根节点为空 则新节点称为根节点
        if (root==null){
            root=new Node(e);
            return true;
        }
        //如果根节点不为空 将它添加到根据节点下
        return root.append(e);
    }
    @Override
    public String toString(){
        if (root==null){
            return "[]";
        }
        /**
         * 在中序遍历当中将访问到的各个节点中的数据添加到builder对象中
         */
        StringBuilder builder=new StringBuilder("[");
        root.inOrder(builder);
        builder.deleteCharAt(builder.lastIndexOf(","));
        return builder.append("]").toString();
    }
}
