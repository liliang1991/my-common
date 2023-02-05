package leetcode;

import java.util.Stack;

/**
 * @Description 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能
 *
 * 解题思路：
 * 队列先进先出，栈先进后出，配合使用 第二个栈 依次从第一个栈顶取元素  stack2.push(stack1.pop());
 * 举例：
 * 假设有元素 1，2，3 依次存入栈1，然后从第一个栈里取出，为3，2，1 ，再放进第二个栈里，取出来就是1，2，3
 *
 *
 * @Date 2023/2/5 下午5:50
 * @Created by Moon
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;


    public CQueue() {
        stack1= new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.empty()) {
           return stack2.pop();
        }
        if(stack1.isEmpty()){
            return -1;
        }
       while(!stack1.isEmpty()){
           stack2.push(stack1.pop());
       }
       return stack2.pop();
    }

}
