package chapter10;

/**
 * Created by NowGood on 2017/3/7.
 */
public class Exercise1014 {
    int[] array;
    int head;
    int tail;
    int size;

    public Exercise1014(int size) {
        this.array = new int[size];
        this.head = 0;
        this.tail = 0;
    }

    public void enqueue(int data) {
        if (head== (tail + 1) % array.length) {
            throw new RuntimeException("overflow");
        } else {
            array[tail] = data;
            tail = (tail + 1) % array.length; // 取余(%)  ,而不是 除(/)
            size++;
        }
    }

    public int dequeue() {
        if (head == tail){
            throw new RuntimeException("underflow");
        } else{
            size--;
            int temp = head;
            head = (head + 1) % array.length;
            return array[temp];
        }
    }
}
