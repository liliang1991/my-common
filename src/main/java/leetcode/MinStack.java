package leetcode;

import java.util.Stack;

/**
 * @Description 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 解题思路
 * 定义两个stack,一个stack存储所有元素，以满足push,pop,top,需求，第二个元素栈顶存储最小元素（每次入栈都和自身栈顶元素比较，如果入栈元素比栈顶元素小，则入栈）
 *
 * @Date 2023/2/6 上午8:49
 * @Created by Moon
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));

    }

    public void pop() {
        //重点为保持两个栈 的 元素一致性
        if (stack.pop().equals(minStack.peek()))
            minStack.pop();

    }

    public int top() {
        return stack.peek();

    }

    public int min() {
        return minStack.peek();

    }

}
