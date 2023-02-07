package leetcode;

/**
 * @Description 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 解题思路
 * 假设链表为 1→2→3→null我们想要把它改成 null←1←2←3
 * 只需要改变当前链表的指针 1->2 改成 2->1 依次循环即可
 * @Date 2023/2/7 上午9:03
 * @Created by Moon
 */
public class ReverseNode {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        //前一个节点
        ListNode pre = head;
        //当前节点
        ListNode cur = head.next;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        ReverseNode reverseNode=new ReverseNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode cur=reverseNode.reverseList(node1);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
