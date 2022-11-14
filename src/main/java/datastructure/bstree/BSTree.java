package datastructure.bstree;

/**
 * @Description 二分查找树
 * @Date 2022/3/18 下午5:45
 * @Created by Moon
 */
public class BSTree<T extends Comparable<T>> {
    private BSTNode mRoot;

    public static class BSTNode<T extends Comparable<T>> {
        private T key;
        private BSTNode<T> left;
        private BSTNode<T> right;
        private BSTNode<T> parent;

        public String toString() {
            return "key:" + key;
        }

        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    /*
       前序遍历
        */
    public void preOrder(BSTNode bstNode) {
        if (bstNode != null) {
            preOrder(bstNode.left);
            preOrder(bstNode.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /*
     * 中序遍历"二叉树"
     */
    private void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /*
     * 新建结点(key)，并将其插入到二叉树中
     *
     * 参数说明：
     *     tree 二叉树的根结点
     *     z 插入的结点
     */
    public void insert(BSTree<T> bst, BSTNode<T> z) {
        int cmp;
        BSTNode<T> y = null;
        //获取根结点
        BSTNode<T> x = bst.mRoot;
        // 查找z的插入位置（y 是父节点）

        while (x != null) {
            y = x;
            cmp = z.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        // y 是根结点
        if (y == null) {
            bst.mRoot = z;
        } else {
            cmp = z.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = z;
            } else {
                y.right = z;
            }
        }

    }

    public void insert(T key) {
        BSTNode<T> z = new BSTNode<T>(key, null, null, null);

        // 如果新建结点失败，则返回。
        if (z != null)
            insert(this, z);

    }

    /*
     * (递归实现)查找"二叉树x"中键值为key的节点
     */
    public BSTNode<T> search(BSTNode<T> bstNode, T key) {
        if (bstNode == null) {
            return null;
        }
        int cmp = key.compareTo(bstNode.key);

        if (cmp < 0) {
            return search(bstNode.left, key);
        } else if (cmp > 0) {
            return search(bstNode.right, key);
        } else {
            return bstNode;
        }

    }

    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /*
     查找最小节点
     */
    public BSTNode<T> mintree(BSTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.left != null) {
            tree = mintree(tree.left);
        }
        return tree;
    }

    public T mintree() {
        BSTNode<T> p = mintree(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /*
    查找最大节点
    */
    public BSTNode<T> maxtree(BSTNode<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.right != null) {
            tree = maxtree(tree.right);
        }
        return tree;
    }

    public T maxtree() {
        BSTNode<T> p = maxtree(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /*
     * 找结点(x)的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"。
     */
    public BSTNode<T> successor(BSTNode<T> x) {
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (x.right != null) {
            return mintree(x.right);
        } else {
            // 如果x没有右孩子。则x有以下两种可能：
            // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
            // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"
            BSTNode<T> y = x.parent;
            while ((y != null) && (x == y.right)) {
                x = y;
                y = y.parent;
            }
            return y;
        }

    }

    /*
     * 删除结点(z)，并返回被删除的结点
     *
     * 参数说明：
     *     bst 二叉树
     *     z 删除的结点
     */
    public BSTNode<T> remove(BSTree<T> bst, BSTNode<T> z) {
        BSTNode<T> x;
        BSTNode<T> y;
        //查找大于该结点"的"最小结点"
        if (z.left == null || z.right == null) {
            y = z;
        } else {
            y = successor(z);
        }
        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }

        if (x != null)
            x.parent = y.parent;

        if (y.parent == null)
            bst.mRoot = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        if (y != z) {
            z.key = y.key;
        }
        return y;
    }

    /*
     * 删除结点(z)，并返回被删除的结点      *
     * 参数说明：
     *     tree 二叉树的根结点
     *     z 删除的结点
     */
    public void remove(T key) {
        BSTNode<T> z, node;

        if ((z = search(mRoot, key)) != null)
            if ((node = remove(this, z)) != null)
                node = null;
    }


}
