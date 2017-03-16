package chapter10;

/**
 * Created by NowGood on 2017/3/7.
 * 总结: 这道题思想很简单, 不过编程中有很多细节需要注意
 *  1.
 */
public class Exercise1015 {
    int[] doublequeue;
    int head;
    int tail;

    public Exercise1015(int size) {
        this.doublequeue = new int[size];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 队尾入队(正常)
     * @param data
     */
    public void endEnqueue(int data) {
        if (head== (tail + 1) % doublequeue.length) {
            throw new RuntimeException("overflow");
        } else {
            doublequeue[tail] = data;
            tail = (tail + 1) % doublequeue.length; // 取余(%)  ,而不是 除(/)
        }
    }

    /**
     * 注意: 在队头入队的话, 新进来的元素变成 队头;
     *  其中注意 当队列为空时,和队列不为空的不同
     * @param data
     */
    public void frontEnqueue(int data) {
        if (head == (tail + 1) % doublequeue.length) {
            throw new RuntimeException("overflow");
        } else {
            if (head == tail) {
                // 很重要,其实这一步是不必要的,只不过这样做了之后,
                // 队列是从数组的第一个元素入队,对于向外部封装了数据结构的使用者来说
                // 这是完全不必要的,我们只需要出队和入队的时候,正确的操作就行了
                doublequeue[head] = data;
                tail++;
            } else {
                head = ((head - 1) + doublequeue.length) % doublequeue.length; // 取余(%)  ,而不是 除(/)
                doublequeue[head] = data;
            }
        }
    }

    /**
     * 在队头出队
     * @return
     */

    public int frontDequeue() {
        if (head == tail){
            throw new RuntimeException("underflow");
        } else{
            int temp = head;
            doublequeue[head] = 0;
            head = (head + 1) % doublequeue.length;
            return doublequeue[temp];
        }
    }

    /**
     * 队列尾部出队
     * @return
     */
    public int endDequeue() {
        if (head == tail){
            throw new RuntimeException("underflow");
        } else{
            tail = (tail - 1 + doublequeue.length) % doublequeue.length;
            return doublequeue[tail];
        }
    }
}
