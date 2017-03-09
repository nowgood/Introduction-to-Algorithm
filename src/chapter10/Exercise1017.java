package chapter10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by NowGood on 2017/3/9.
 */
public class Exercise1017 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public Exercise1017() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int data) {
        if (queue2.isEmpty()){
            queue1.offer(data);
        } else {
            queue2.offer(data);
        }

    }
    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("underflow");
        }
        int temp = 0;
        if (queue1.isEmpty()) {
            while (queue2.peek() != null) {
                temp = queue2.poll();
                if (queue2.peek() != null) {
                    queue1.offer(temp);
                }
            }
            // 1. 这里要用 else if 而不是 if;
            // 2. 在遇到类似问题时,else if 和 if 表现了两种不同的作用,下次思考时,要注意;
            // 3. 在这里, 如果用 if 的话,如果,先是 queue1 空的话, pop之后, queue2 变成空,也就是说出了 pop了 两次,error

        } else if (queue2.isEmpty()) {
            while (queue1.peek() != null) {
                temp = queue1.poll();
                if (queue1.peek() != null) {
                    queue2.offer(temp);
                }
            }
        }
        return temp;
    }

}
