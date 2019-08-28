package common.bs;
/*
    二叉树
 */
public class BSSearchTree<T extends Comparable<T>>{
    private Node<T> mRoot;
    public  Node<T> find(Node<T> node,T v){
        if(node==null){
            return node;
        }
        if(v.compareTo(node.value)<0){
            find(node.left,v);
        }else if(v.compareTo(node.value)>0){
            find(node.right,v);

        }else {
            return  node;
        }
        return null;
    }

    public class Node<T extends Comparable<T>>{
      private   T value;
       private   Node left;
      private   Node right;
      private   Node parent;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node(T value, Node left, Node right, Node parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    public BSSearchTree() {
        this.mRoot = null;
    }
}
