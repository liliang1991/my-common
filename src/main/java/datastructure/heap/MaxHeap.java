package datastructure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 最大堆
 * @Date 2022/3/25 上午10:34
 * @Created by Moon
 */
public class MaxHeap<T extends Comparable<T>> {
    private List<T> mHeap;

    public MaxHeap() {
        mHeap = new ArrayList<>();
    }
    /*
     * 最大堆的向上调整算法(从start开始向上直到0，调整堆)
     *
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)，父节点位置是（N-1）/2
     *
     * 参数说明：
     *     start -- 被上调节点的起始位置(一般为数组中最后一个元素的索引)
     */

    protected void filterup(int start) {
        int c = start;            // 当前节点(current)的位置
        int p = (c - 1) / 2;        // 父(parent)结点的位置
        T temp = mHeap.get(c);
        while (c > 0) {
            int cmp = temp.compareTo(mHeap.get(p));
            if (cmp > 0) {
                mHeap.set(c, mHeap.get(p));
                c = p;
                p = (p - 1) / 2;
            } else {
                break;
            }
        }
        mHeap.set(c, temp);

    }

    /*
     * 将data插入到二叉堆中
     */
    public void insert(T data) {
        int size = mHeap.size();

        mHeap.add(data);    // 将"数组"插在表尾
        filterup(size);        // 向上调整堆
    }

    /*
     * 删除最大堆中的data
     *
     * 返回值：
     *      0，成功
     *     -1，失败
     */
    public int remove(T data) {
        // 如果"堆"已空，则返回-1
        if (mHeap.isEmpty() == true)
            return -1;

        // 获取data在数组中的索引
        int index = mHeap.indexOf(data);
        if (index == -1)
            return -1;

        int size = mHeap.size();
        mHeap.set(index, mHeap.get(size - 1));// 用最后元素填补
        mHeap.remove(size - 1);                // 删除最后的元素

        if (mHeap.size() > 1)
            filterup(mHeap.size() - 1);    // 从index号位置开始自上向下调整为最小堆

        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mHeap.size(); i++)
            sb.append(mHeap.get(i) + " ");

        return sb.toString();
    }

    public static void main(String[] args) {
        int i;
        int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
        MaxHeap<Integer> tree = new MaxHeap<Integer>();

        System.out.printf("== 依次添加: ");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
            tree.insert(a[i]);
        }

        System.out.printf("\n== 最 大 堆: %s", tree);

        i = 85;
        tree.insert(i);
        System.out.printf("\n== 添加元素: %d", i);
        System.out.printf("\n== 最 大 堆: %s", tree);

        i = 90;
        tree.remove(i);
        System.out.printf("\n== 删除元素: %d", i);
        System.out.printf("\n== 最 大 堆: %s", tree);
        System.out.printf("\n");
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */