package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 从尾到头打印链表
 * 解题思路
 * 遍历链表，将其放入栈中，然后取出（pop）
 * @Date 2023/2/6 下午2:05
 * @Created by Moon
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        while (head != null) {
          stack.push(head.val);
          head=head.next;
        }
        int[] result=new int[stack.size()];
        for(int i=0;i<result.length;i++){
            result[i]=stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        while(node1!=null){
//            System.out.println(node1.val);
//            node1=node1.next;
//        }
        int result[]= solution.reversePrint(node1);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
