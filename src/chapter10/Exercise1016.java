package chapter10;

import javax.management.relation.RelationNotFoundException;
import java.util.Stack;

/**
 * 问题描述: 如何用2个栈 实现一个队列
 *
 * Created by NowGood on 2017/3/9.
 */
public class Exercise1016 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Exercise1016() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(int data) {
        stack1.push(data);
    }
    public int dequeue() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if(!stack2.isEmpty()) {
                return  stack2.pop();
            } else {
                throw new RuntimeException("underflow");
            }
        }
    }
}
