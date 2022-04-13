package datastructure.bstree;

/**
 * @Description 二分查找树 测试类
 * @Date 2022/3/18 下午6:00
 * @Created by Moon
 */
public class BSTreeTest {
    private static final int arr[] = {1, 5, 4, 3, 2, 6};

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<Integer>();
        //添加
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            tree.insert(arr[i]);
        }
        System.out.println(tree.search(4));
    }
}
