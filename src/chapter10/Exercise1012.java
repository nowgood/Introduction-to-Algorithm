package chapter10;

/**
 * Created by NowGood on 2017/3/7.
 */
public class Exercise1012 {
    int[] array;
    int size1, size2;
    int top1, top2;



    public Exercise1012(int size) {
        this.array = new int[size];
        this.size1 = 0;
        this.size2 = 0;
        this.top1 = -1;
        this.top2 = size;
    }

    public class Stack1 {
        public void push(int data) {
            if ((size1 + size2) < array.length ) {
                top1 += 1;
                size1 += 1;
                array[top1] = data;
            } else {
                throw new RuntimeException("overflow");
            }
        }

        public int pop() {
            if (empty()) {
                throw new RuntimeException("underflow");
            } else {
                size1++;
                return array[(--top1) + 1];
            }
        }

        public boolean empty() {
            if (size1 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public class Stack2 {
        public void push(int data) {
            if ((size1 + size2) < array.length ) {
                size2++;
                array[--top2] = data;
            } else {
                throw new RuntimeException("overflow");
            }
        }

        public int pop() {
            if (empty()) {
                throw new RuntimeException("underflow");
            } else {
                size2--;
                return array[(++top2) - 1];
            }
        }

        public boolean empty() {
            if (size2 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
